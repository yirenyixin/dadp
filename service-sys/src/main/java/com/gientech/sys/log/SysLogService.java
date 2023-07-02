package com.gientech.sys.log;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.IpUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.core.security.util.HttpUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录日志--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysLogService extends BaseService<SysLogMapper, SysLog> {

	/**
	 * 【1】查询和分页
	 * 
	 * @param dto
	 *
	 * @return
	 */
	public DataGrid<SysLogVO> listLog(SysLogDTO4List dto) {
		log.info("【查询条件--日志】" + dto);

		// 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
		MyStringUtil.addObjectLike(dto, "userId,userName,logInfo,ipAddr");

		// 【3】构造分页参数
		Page<SysLogVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

		return new DataGrid<SysLogVO>(this.getBaseMapper().getSysLogList(page, dto), page.getTotal());
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

	/**
	 * 【11】保存登录日志
	 * 
	 * @param userId
	 * @param userName
	 * @param logInfo
	 * @param ipaddr
	 * @throws AppException
	 */
	public void saveLog(String userId, String userName, String logInfo) {

		SysLog sysLog = new SysLog();

		sysLog.setUserId(userId);
		sysLog.setUserName(userName);
		sysLog.setLogInfo(logInfo);
		sysLog.setLogTime(new Date());
		sysLog.setIpAddr(IpUtil.getIpAddr(HttpUtil.getRequest()));

		this.save(sysLog);

		log.info("【新增--日志】" + sysLog);
	}
}
