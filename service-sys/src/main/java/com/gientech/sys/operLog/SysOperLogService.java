package com.gientech.sys.operLog;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 操作日志--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysOperLogService extends BaseService<SysOperLogMapper, SysOperLog> {

	/**
	 * 【1】查询和分页
	 * 
	 * @param dto
	 *
	 * @return
	 */
	public DataGrid<SysOperLogVO> listOperLog(SysOperLogDTO4List dto) {
		log.info("【list查询条件--操作日志】" + dto);

		// 【1】查询结束日期，要加上86399秒[24*60*60-1]，变成23:59:59这样的时间
		if (dto.getDateTo() != null) {
			dto.setDateTo(DateUtil.offsetSecond(dto.getDateTo(), 86399));
		}

		// 【2】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
		MyStringUtil.addObjectLike(dto, "moduleName,userId,orgId,reqUrl,reqMethod,reqMode,ipAddr,reqParam,result");

		// 【3】构造分页参数
		Page<SysOperLogVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<SysOperLogVO>(this.getBaseMapper().getSysOperLogList(page, dto), page.getTotal());
	}

	/**
	 * 【2】新增--保存
	 * 
	 * @param dto
	 */
	public void saveOperLog(SysOperLog sysOperLog) {

		sysOperLog.setLogTime(new Date());
		this.save(sysOperLog);
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

}
