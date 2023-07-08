package com.gientech.sys.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class SysUserService extends BaseService<SysUserMapper, SysUser> {

	@Autowired
	private SysUserMapper sysUserMapper;

	/**
	 * 查询和分页
	 *
	 * @param dto 查询DTO
	 * @return 分页结果
	 */
	public DataGrid<SysUserVO> listSysUser(SysUserDTO4List dto) {
		log.info("【list查询条件--SYS_USER】" + dto);

		// 处理模糊查询条件的like
		MyStringUtil.addObjectLike(dto, "userName,loginName,tel");

		// 处理排序条件
		dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "USER_ID asc"));

		// 构造分页参数
		Page<SysUserVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<>(this.getBaseMapper().getSysUserList(page, dto), page.getTotal());
	}

	/**
	 * 新增 SYS_USER
	 *
	 * @param dto 新增DTO
	 */
	public void saveSysUser(SysUserDTO4Save dto) {
		log.info("【新增--SYS_USER】" + dto);

		// 从dto中复制属性
		SysUser sysUser = new SysUser();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysUser);

		// 校验 userId 是否存在
		if (isExistUserId(sysUser.getUserId())) {
			throw new AppException("新增失败，userId【" + sysUser.getUserId() + "】已经存在！");
		}

		this.save(sysUser);
	}

	/**
	 * 修改 SYS_USER
	 *
	 * @param dto 修改DTO，一定要传主键
	 */
	public void updateSysUser(SysUserDTO4Update dto) {
		log.info("【修改--SYS_USER】" + dto);

		// 从dto中复制属性
		SysUser sysUser = new SysUser();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysUser);

		// 更新 SYS_USER 信息
		if (!this.updateById(sysUser)) {
			throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
		}
	}

	/**
	 * 删除 SYS_USER
	 *
	 * @param userId 用户ID
	 */
	public void deleteSysUser(String userId) {
		log.info("【删除--SYS_USER】" + userId);

		// 删除 SYS_USER
		this.removeById(userId);
	}

	/**
	 * 检查 userId 是否存在
	 *
	 * @param userId 用户ID
	 * @return 是否存在
	 */
	private boolean isExistUserId(String userId) {
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("USER_ID", userId);
		return this.getOne(queryWrapper) != null;
	}
}