package com.gientech;

import com.gientech.common.view.DataGrid;
import com.gientech.pmm.remind.*;
import com.gientech.pcm.cust.*;
import com.gientech.pcm.userRel.*;
import com.gientech.pcm.wealth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class StartPcm {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StartPcm.class, args);
		System.out.println("---------------pcm启动成功---------------");
	}

	@Component
	public static class MyApplicationRunner implements ApplicationRunner {
		private  PmmRemindService pmmRemindService;
		private PcmCustService pcmCustService;
		private PcmWealthService pcmWealthService;
		private PcmUserRelService pcmUserRelService;

		@Autowired
		public MyApplicationRunner(@Lazy PmmRemindService pmmRemindService, PcmCustService pcmCustService, PcmWealthService pcmWealthService, PcmUserRelService pcmUserRelService) {
			this.pmmRemindService = pmmRemindService;
			this.pcmCustService = pcmCustService;
			this.pcmWealthService = pcmWealthService;
			this.pcmUserRelService = pcmUserRelService;
		}

		public void processReminders() throws Exception {
			// 获取当前时间
			Calendar now = Calendar.getInstance();
			List<PmmRemindDTO4Save> remindList = new ArrayList<>();//增加提醒
			List remindDTO4Deletes=new ArrayList<>();//删除已经过了有效期的提醒

			//调用pmmRemindService方法
			PmmRemindDTO4List remindDTO4List=new PmmRemindDTO4List();
			remindDTO4List.setPageNo(1);
			remindDTO4List.setPageSize(9999);
			DataGrid<PmmRemindVO> dataGrid0 =pmmRemindService.listRemind(remindDTO4List);
			if (dataGrid0 != null && dataGrid0.getRows() != null) {
				for (int i = 0; i < dataGrid0.getRows().size(); i++) {
					PmmRemindVO remindVO=dataGrid0.getRows().get(i);
					if(remindVO.getCreateDate()!=null){
						int valIdDay=remindVO.getValidDay();
						Date createDate=remindVO.getCreateDate();//这里读出来的数据是是EEE MMM dd HH:mm:ss zzz yyyy格式跟数据库yyyy-MM-dd HH:mm:ss不一样
						//转换
						String targetDateFormatStr = "yyyy-MM-dd HH:mm:ss";
						String cDate=new SimpleDateFormat(targetDateFormatStr).format(createDate);
						int comparisonResult = compareDatesAndValidate(cDate, valIdDay);
						if(comparisonResult>0){//超过有效日期
							remindDTO4Deletes.add(remindVO.getRemindId());
						}
					}
				}
			}
			// 调用PcmCustService的方法
			PcmCustDTO4List custDTO4List = new PcmCustDTO4List();
			custDTO4List.setPageNo(1);
			custDTO4List.setPageSize(9999);
			DataGrid<PcmCustVO> dataGrid1 = pcmCustService.listCust(custDTO4List);
			if (dataGrid1 != null && dataGrid1.getRows() != null) {
				for (int i = 0; i < dataGrid1.getRows().size(); i++) {
					PcmCustVO custVO = dataGrid1.getRows().get(i);
					if (custVO.getBirthday() != null && !custVO.getBirthday().isEmpty()) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
						Date utilDate = dateFormat.parse(custVO.getBirthday());
						LocalDate birthday = LocalDate.ofInstant(utilDate.toInstant(), ZoneId.systemDefault());

						long daysDifference = getDaysDifference(LocalDate.now(), birthday);
						if (daysDifference >= 14 && daysDifference <= 15) {
							PmmRemindDTO4Save dto = new PmmRemindDTO4Save();
							dto.setRemindContent("客户" + custVO.getCustId() + "生日还有" + "15" + "天就要到了！");
							dto.setValidDay(2);
							dto.setCreateDate(now.getTime());
							dto.setCustId(custVO.getCustId());
							dto.setLawOrgId(custVO.getLawOrgId());
							dto.setEventType("11104");
							dto.setEventSmallType("1110401");
							remindList.add(dto);
						}
					}
				}
			}

			// 调用PcmWealthService的方法
			PcmWealthDTO4List wealthDTO4List = new PcmWealthDTO4List();
			wealthDTO4List.setPageNo(1);
			wealthDTO4List.setPageSize(9999);
			DataGrid<PcmWealthVO> dataGrid2 = pcmWealthService.listWealth(wealthDTO4List);
			if (dataGrid2 != null && dataGrid2.getRows() != null) {
				for (int i = 0; i < dataGrid2.getRows().size(); i++) {
					PcmWealthVO pcmWealthVO = dataGrid2.getRows().get(i);
					if (pcmWealthVO.getEndDate() != null) {
						long daysDifference = getDaysWealthDifference(now.getTime(), pcmWealthVO.getEndDate());
						if (daysDifference >= 9 && daysDifference <= 10) {
							PmmRemindDTO4Save dto = new PmmRemindDTO4Save();
							dto.setRemindContent("客户" + pcmWealthVO.getCustId() + "理财"+pcmWealthVO.getProdName()+"还有" + "10" + "天到期！");
							dto.setValidDay(2);
							dto.setCreateDate(now.getTime());
							dto.setCustId(pcmWealthVO.getCustId());
							dto.setLawOrgId(pcmWealthVO.getLawOrgId());
							dto.setEventType("11104");
							dto.setEventSmallType("1110401");
							remindList.add(dto);
						}
					}
				}
				// 批量保存理财到期提醒
				for (PmmRemindDTO4Save remind : remindList) {
					pmmRemindService.saveRemind(remind);
				}
				//删除超过有效期的提醒
				for(int i=0;i<remindDTO4Deletes.size();i++){
					pmmRemindService.deleteRemind(remindDTO4Deletes.get(i).toString());
				}
			}
		}

		/**
		 * 计算两个日期之间的天数差
		 */
		private long getDaysDifference(LocalDate now, LocalDate date2) {
			LocalDate birthday = date2.withYear(now.getYear()); // 设置生日的年份为当前年份
			long difference = ChronoUnit.DAYS.between(now, birthday);
			return Math.abs(difference);
		}

		private long getDaysWealthDifference(Date date1, String date2) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date endDate;
			try {
				endDate = dateFormat.parse(date2);
			} catch (ParseException e) {
				e.printStackTrace();
				return 0;
			}
			long difference = Math.abs(date1.getTime() - endDate.getTime());
			return difference / (24 * 60 * 60 * 1000);
		}
		public static int compareDatesAndValidate(String createDateStr, int valIdDay) throws ParseException {
			// 定义日期格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			// 将日期字符串解析为Date对象
			Date createDate = dateFormat.parse(createDateStr);

			// 将Java的Date对象转换为Java 8的LocalDate对象
			LocalDate currentDate = LocalDate.now();
			LocalDate createLocalDate = createDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			// 计算两个日期之间的天数差
			long daysDifference = Duration.between(createLocalDate.atStartOfDay(), currentDate.atStartOfDay()).toDays();

			// 将天数差与valIdDay进行比较
			return Long.compare(daysDifference, valIdDay);
		}

		@Override
		public void run(ApplicationArguments args) throws Exception {
			// 无需在此处执行逻辑

		}
	}

	@Component
	public static class ScheduledTasks {
		private MyApplicationRunner myApplicationRunner;

		@Autowired
		public ScheduledTasks(MyApplicationRunner myApplicationRunner) {
			this.myApplicationRunner = myApplicationRunner;
		}

		@Scheduled(cron = "00 00 00 * * ?") // 每天午夜12点触发任务 分别是秒 分  时
		public void runProcessReminders() throws Exception {
			myApplicationRunner.processReminders();
		}
	}

}