package com.gientech.sys.func;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.sys.menu.SysMenuService;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysFuncService extends BaseService<SysFuncMapper, SysFunc> {

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param dto
	 *
	 * @return
	 */
	public DataGrid<SysFuncVO> listFunc(SysFuncDTO4List dto) {
		log.info("【list查询条件--功能】" + dto);

		// 【2】构造分页参数
		Page<SysFuncVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<SysFuncVO>(this.getBaseMapper().getSysFuncList(page, dto), page.getTotal());
	}

	/**
	 * 【2】新增--保存
	 * 
	 * @param dto
	 */
	public void saveFunc(SysFuncDTO4Save dto) {
		log.info("【新增--功能】" + dto);

		// 【1】 从dto中copy属性
		SysFunc sysFunc = new SysFunc();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysFunc);

		// 【2】 校验id是否存在
		if (isExistFuncId(sysFunc.getFuncId())) {
			throw new AppException("新增失败，功能ID【" + sysFunc.getFuncId() + "】已经存在！");
		}

		// 【3】功能ID必须是 menuId- 开头
		if (!sysFunc.getFuncId().startsWith(sysFunc.getMenuId() + "-")) {
			throw new AppException("新增失败，功能ID【" + sysFunc.getFuncId() + "】必须以【" + sysFunc.getMenuId() + "-】开头！");
		}

		// 【4】防止功能ID 和 菜单ID重复。
		if (this.sysMenuService.isExistMenuId(sysFunc.getFuncId())) {
			throw new AppException("新增失败，功能ID【" + sysFunc.getFuncId() + "】在菜单表中有数据，功能ID和菜单ID不能重复！");
		}

		sysFunc.setVer(1);// 数据版本
		this.save(sysFunc);
	}

	/**
	 * 【3】修改
	 * 
	 * @param dto
	 */
	public void updateFunc(SysFuncDTO4Update dto) {
		log.info("【修改--功能】" + dto);

		// 【1】 从dto中copy属性
		SysFunc sysFunc = new SysFunc();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysFunc);

		if (!this.updateById(sysFunc)) {
			throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
		}
	}

	/**
	 * 【4】删除--多个id以逗号分隔
	 * 
	 * @param funcIds
	 */
	public void deleteFunc(String funcIds) {
		log.info("【删除--功能】" + funcIds);

		// 【1】删除
		String[] funcIdArray = StrUtil.splitToArray(funcIds, ",");
		for (String funcId : funcIdArray) {
			this.removeById(funcId);
		}
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

	/**
	 * 【21】检查funcId是否存在
	 * 
	 * @param funcId
	 * @return
	 */
	private boolean isExistFuncId(String funcId) {
		return this.getById(funcId) != null;
	}
}
