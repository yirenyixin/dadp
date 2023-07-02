package com.gientech.sys.codeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.MyConstants;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.core.redis.RedisService;
import com.gientech.sys.codeInfo.SysCodeInfo;
import com.gientech.sys.codeInfo.SysCodeInfoService;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 代码类别--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysCodeTypeService extends BaseService<SysCodeTypeMapper, SysCodeType> {

	@Autowired
	private RedisService redisService;

	@Autowired
	private SysCodeInfoService sysCodeInfoService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param dto
	 *
	 * @return
	 */
	public DataGrid<SysCodeTypeVO> listCodeType(SysCodeTypeDTO4List dto) {
		log.info("【list查询条件--代码类别】" + dto);

		// 【2】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
		MyStringUtil.addObjectLike(dto, "codeTypeId,codeTypeName,remark");

		// 【3】处理前端传入排序条件
		dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.CODE_TYPE_ID asc"));

		// 【4】构造分页参数
		Page<SysCodeTypeVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<SysCodeTypeVO>(this.getBaseMapper().getSysCodeTypeList(page, dto), page.getTotal());
	}

	/**
	 * 【2】新增--保存
	 * 
	 * @param dto
	 */
	public void saveCodeType(SysCodeTypeDTO4Save dto) {
		log.info("【新增--代码类别】" + dto);

		// 【1】 从dto中copy属性
		SysCodeType sysCodeType = new SysCodeType();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysCodeType);

		// 【2】 校验id是否存在
		if (isExistCodeTypeId(sysCodeType.getCodeTypeId())) {
			throw new AppException("新增失败，代码类别ID【" + sysCodeType.getCodeTypeId() + "】已经存在！");
		}

		sysCodeType.setVer(1);// 数据版本
		this.save(sysCodeType);
	}

	/**
	 * 【3】修改
	 * 
	 * @param dto
	 */
	public void updateCodeType(SysCodeTypeDTO4Update dto) {
		log.info("【修改--代码类别】" + dto);

		// 【1】 从dto中copy属性
		SysCodeType sysCodeType = new SysCodeType();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysCodeType);

		if (!this.updateById(sysCodeType)) {
			throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
		}
	}

	/**
	 * 【4】删除--多个id以逗号分隔
	 * 
	 * @param codeTypeIds
	 */
	public void deleteCodeType(String codeTypeIds) {
		log.info("【删除--代码类别】" + codeTypeIds);

		// 【1】删除
		String[] codeTypeIdArray = StrUtil.splitToArray(codeTypeIds, ",");
		for (String codeTypeId : codeTypeIdArray) {
			this.removeById(codeTypeId);

			// 【2】删除子表
			QueryWrapper<SysCodeInfo> codeInfoWrapper = new QueryWrapper<>();
			codeInfoWrapper.eq("CODE_TYPE_ID", codeTypeId);
			this.sysCodeInfoService.remove(codeInfoWrapper);

			// 【3】删除缓存
			this.redisService.delKey(MyConstants.REDIS_SYS_CODE_TYPE + codeTypeId);

		}
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

	/**
	 * 【21】检查codeTypeId是否存在
	 * 
	 * @param codeTypeId
	 * @return
	 */
	private boolean isExistCodeTypeId(String codeTypeId) {
		return this.getById(codeTypeId) != null;
	}
}
