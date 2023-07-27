package com.gientech.sys.user;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

import java.util.List;

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
		MyStringUtil.addObjectLike(dto, "userName,loginName");

		// 处理排序条件
		dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "CREATE_TIME desc"));

		// 构造分页参数
		Page<SysUserVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<>(this.getBaseMapper().getSysUserList(page, dto), page.getTotal());
	}


	private static String unescapeJsonString(String jsonString) {
		jsonString = jsonString.replace("\\\"", "\"");  // 替换转义的双引号
		jsonString = jsonString.replace("\\\\", "\\");  // 替换转义的反斜杠
		// 添加其他需要替换的转义字符，如 \n、\r 等等

		return jsonString;
	}
	public String listSysUserCodeInfo(SysUserDTO4List dto){
		// 处理模糊查询条件的like
		MyStringUtil.addObjectLike(dto, "userName,loginName");

		// 处理排序条件
		dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "CREATE_TIME desc"));

		// 构造分页参数
		Page<SysUserVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());
		List<SysUserVO> list = this.getBaseMapper().getSysUserList(page, dto);



		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		JSONObject objectFirst = new JSONObject();
		objectFirst.put("value",null);
		objectFirst.put("content","请选择");
		objectFirst.put("parentValue",null);
		jsonArray.add(objectFirst);

		for(SysUserVO user : list){
			if(!user.getRoleId().equals("admin")){
				JSONObject object = new JSONObject();
				String value = user.getUserId();
				String content = user.getUserName();
				String parentValue = null;
				object.put("value",value);
				object.put("content",content);
				object.put("parentValue",parentValue);
				jsonArray.add(object);
			}
		}
		jsonObject.put("userCodeInfo",jsonArray);
		System.out.println(unescapeJsonString(jsonObject.toJSONString()));
		return unescapeJsonString(jsonObject.toJSONString());
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
	 * @param userIds 多个 userId 以逗号分隔
	 */
	public void deleteSysUser(String userIds) {
		log.info("【删除--SYS_USER】" + userIds);

		// 删除 SYS_USER
		String[] userIdArray = StrUtil.splitToArray(userIds, ",");
		for (String userId : userIdArray) {
			this.removeById(userId);
		}
	}

	/**
	 * 检查 userId 是否存在
	 *
	 * @param userId userId
	 * @return 是否存在
	 */
	private boolean isExistUserId(String userId) {
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("USER_ID", userId);
		return this.getOne(queryWrapper) != null;
	}
}