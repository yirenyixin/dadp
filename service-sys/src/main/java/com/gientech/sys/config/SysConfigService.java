package com.gientech.sys.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.MyConstants;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.core.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统参数--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysConfigService extends BaseService<SysConfigMapper, SysConfig> {

	@Autowired
	private RedisService redisService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param dto
	 *
	 * @return
	 */
	public DataGrid<SysConfigVO> listConfig(SysConfigDTO4List dto) {
		log.info("【list查询条件--系统参数】" + dto);

		// 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
		MyStringUtil.addObjectLike(dto, "configId,configName,configValue");

		// 【2】构造分页参数
		Page<SysConfigVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<SysConfigVO>(this.getBaseMapper().getSysConfigList(page, dto), page.getTotal());
	}

	/**
	 * 【2】新增--保存
	 * 
	 * @param dto
	 */
	public void saveConfig(SysConfigDTO4Save dto) {
		log.info("【新增--系统参数】" + dto);

		// 【1】 从dto中copy属性
		SysConfig sysConfig = new SysConfig();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysConfig);

		// 【2】 校验id是否存在
		if (isExistConfigId(sysConfig.getConfigId())) {
			throw new AppException("新增失败，系统参数ID【" + sysConfig.getConfigId() + "】已经存在！");
		}

		sysConfig.setVer(1);// 数据版本
		this.save(sysConfig);

		// 【3】更新缓存
		this.redisService.set(MyConstants.REDIS_SYS_CONFIG + sysConfig.getConfigId(), sysConfig);

	}

	/**
	 * 【3】修改
	 * 
	 * @param dto
	 */
	public void updateConfig(SysConfigDTO4Update dto) {
		log.info("【修改--系统参数】" + dto);

		// 【1】 从dto中copy属性
		SysConfig sysConfig = new SysConfig();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysConfig);

		if (!this.updateById(sysConfig)) {
			throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
		}

		// 【2】更新缓存
		this.redisService.set(MyConstants.REDIS_SYS_CONFIG + sysConfig.getConfigId(), sysConfig);
	}

	/**
	 * 【4】删除--多个id以逗号分隔
	 * 
	 * @param configIds
	 */
	public void deleteConfig(String configIds) {
		log.info("【删除--系统参数】" + configIds);

		// 【1】删除
		String[] configIdArray = StrUtil.splitToArray(configIds, ",");
		for (String configId : configIdArray) {
			this.removeById(configId);

			// 【2】删除缓存
			this.redisService.delKey(MyConstants.REDIS_SYS_CONFIG + configId);
		}
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

	/**
	 * 【21】检查configId是否存在
	 * 
	 * @param configId
	 * @return
	 */
	private boolean isExistConfigId(String configId) {
		return this.getById(configId) != null;
	}
}
