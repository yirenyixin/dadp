package com.gientech.sys.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysUserService extends BaseService<SysUserMapper, SysUser> {

	/**
	 * 【1】查询和分页
	 * 
	 * @param dto
	 *
	 * @return
	 */
	public DataGrid<SysUserVO> listUser(SysUserDTO4List dto) {
		log.info("【查询条件--用户】" + dto);

		// 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
		MyStringUtil.addObjectLike(dto, "userId,userName,loginName,tel");

		// 【2】处理前端传入排序条件
		dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.SORT_NO asc, a.USER_ID asc"));

		// 【3】构造分页参数
		Page<SysUserVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<SysUserVO>(this.getBaseMapper().getSysUserList(page, dto), page.getTotal());
	}

	/**
	 * 【2】新增--保存
	 * 
	 * @param dto
	 */
	public void saveUser(SysUserDTO4Save dto) {
		log.info("【新增--用户】" + dto);

		// 【1】 从dto中copy属性
		SysUser sysUser = new SysUser();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysUser);

		// 【2】 校验id是否存在
		if (isExistUserId(sysUser.getUserId())) {
			throw new AppException("新增失败，用户ID【" + sysUser.getUserId() + "】已经存在！");
		}

		// 【3】校验LoginName是否重复.
		if (isExistLoginName(sysUser)) {
			throw new AppException("保存失败,用户登陆名【" + sysUser.getLoginName() + "】已经存在!");
		}

		// 【4】新增的时候密码要用-Security的加密，
		sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));

		// 【5】拥有的全部角色中，取第一个角色，变成当前角色。
		sysUser.setRoleId(StringUtils.substringBefore(sysUser.getRoleIds(), ","));

		sysUser.setVer(1);// 数据版本
		this.save(sysUser);
	}

	/**
	 * 【3】修改
	 * 
	 * @param dto
	 */
	public void updateUser(SysUserDTO4Update dto) {
		log.info("【修改--用户】" + dto);

		// 【1】 从dto中copy属性
		SysUser sysUser = new SysUser();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysUser);

		// 【2】校验LoginName是否重复.
		if (isExistLoginName(sysUser)) {
			throw new AppException("保存失败,用户登陆名【" + sysUser.getLoginName() + "】已经存在!");
		}

		// 【3】修改的时候密码要用-Security的加密，
		SysUser oldSysUser = this.getById(sysUser.getUserId());
		if (!oldSysUser.getPassword().equals(dto.getPassword())) {// 前段传回来的密码，和数据库不一致。。说明前台修改了密码。
			sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
		}

		// 【4】拥有的全部角色中，取第一个角色，变成当前角色。
		sysUser.setRoleId(StringUtils.substringBefore(sysUser.getRoleIds(), ","));

		if (!this.updateById(sysUser)) {
			throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
		}
	}

	/**
	 * 【4】删除--多个id以逗号分隔
	 * 
	 * @param userIds
	 */
	public void deleteUser(String userIds) {
		log.info("【删除--用户】" + userIds);

		// 【1】删除
		String[] userIdArray = StrUtil.splitToArray(userIds, ",");
		for (String userId : userIdArray) {
			this.removeById(userId);
		}
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

	/**
	 * 【21】检查userId是否存在
	 * 
	 * @param userId
	 * @return
	 */
	private boolean isExistUserId(String userId) {
		return this.getById(userId) != null;
	}

	/**
	 * 【22】检查loginName是否重复
	 *
	 * @param sysUser
	 * @return
	 */
	private boolean isExistLoginName(SysUser sysUser) {
		if (StringUtils.isEmpty(sysUser.getUserId())) {// 【1】新增且userId不是前段输入的时候。userId才会为null
			QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
			queryWrapper.eq("LOGIN_NAME", sysUser.getLoginName());
			return this.getOne(queryWrapper) != null;

		} else {
			QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
			queryWrapper.ne("USER_ID", sysUser.getUserId());// 不等于当前userId
			queryWrapper.eq("LOGIN_NAME", sysUser.getLoginName());
			return this.getOne(queryWrapper) != null;
		}
	}

}
