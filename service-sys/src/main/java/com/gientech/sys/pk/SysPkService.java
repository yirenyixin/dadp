package com.gientech.sys.pk;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gientech.common.util.MyStringUtil;
import com.gientech.core.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 流水号主键--Service
 * 
 * @author 胡砥峰
 */
@Service
@Transactional
public class SysPkService extends BaseService<SysPkMapper, SysPk> {

	/**
	 * 【11】生成一个主键，带前缀. 例如：XS201411290003; XS0001 这2种
	 * 
	 * @param prefix     输入前缀，不空
	 * @param howNum     几位数字，会自动补0
	 * @param ifNeedDate 是否需要日期，可空
	 * 
	 * @return 带前缀的ID
	 */
	public synchronized String createIdHavePrefix(String prefix, int howNum, boolean ifNeedDate) {
		return prefix + createId(prefix, howNum, ifNeedDate);
	}

	/**
	 * 生成一个主键，不带前缀. 例如：201411290003; 0001 这2种
	 *
	 * @param prefix     输入前缀，不空
	 * @param howNum     几位数字，会自动补0
	 * @param ifNeedDate 是否需要日期，可空
	 *
	 * @return 不带前缀的ID
	 * @throws InterruptedException
	 */
	public synchronized String createId(String prefix, int howNum, boolean ifNeedDate) {

		// 【1】prefix不能为空
		if (StringUtils.isEmpty(prefix)) {
			return "前缀不能为空";
		}

		// 【2】howNum必须大于0
		if (howNum < 1) {
			return "几位数字必须大于0";
		}

		String pkDate = "";

		// 【3】准备生成id--- 先判断今天有没有这个前缀的记录
		List<SysPk> list = new ArrayList<SysPk>();

		if (ifNeedDate) {// 每天从0001开始累加
			pkDate = DateUtil.format(new Date(), "yyyyMMdd");// 当天日期

			QueryWrapper<SysPk> queryWrapper = new QueryWrapper<SysPk>();
			queryWrapper.eq("PK_PREFIX", prefix);
			queryWrapper.eq("PK_DATE", pkDate);
			list = this.list(queryWrapper);
		} else {
			QueryWrapper<SysPk> queryWrapper = new QueryWrapper<SysPk>();
			queryWrapper.eq("PK_PREFIX", prefix);
			list = this.list(queryWrapper);
		}

		int pkMax = 1;// 最大值
		if (list.size() > 0) {// 今天有记录， pkMax +1后更新
			SysPk sysPk = list.get(0);

			pkMax = sysPk.getPkMax() + 1;
			sysPk.setPkMax(pkMax);

			this.updateById(sysPk);
		} else {// 今天没记录，插入一条新的SysPk，且pkMax=1
			SysPk sysPk = new SysPk();
			sysPk.setPkPrefix(prefix);
			sysPk.setPkMax(pkMax);// 一开始是1
			sysPk.setPkDate(pkDate);

			this.save(sysPk);
		}

		return pkDate + MyStringUtil.addPrefix(pkMax, howNum);
	}

}
