package com.gientech;

import com.gientech.common.view.DataGrid;
import com.gientech.pcm.depCurr.PcmDepCurrDTO4List;
import com.gientech.pcm.depCurr.PcmDepCurrVO;
import com.gientech.pmm.remind.PmmRemindDTO4List;
import com.gientech.pmm.remind.PmmRemindDTO4Update;
import com.gientech.pmm.remind.PmmRemindService;
import com.gientech.pmm.remind.PmmRemindVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@EnableAsync // 开启异步调用(操作日志要用)
public class StartPcm {

	public static void main(String[] args) {

		SpringApplication.run(StartPcm.class, args);

		System.out.println("---------------pmm启动成功---------------");
	}

//	@Component
//	public static class MyApplicationRunner implements ApplicationRunner {
//		private PmmRemindService pmmRemindService; // 注入PmmRemindService类的实例
//
//		@Autowired
//		public MyApplicationRunner(PmmRemindService pmmRemindService) {
//			this.pmmRemindService = pmmRemindService;
//		}
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
//			// 在应用程序启动后启动线程
//			Thread thread = new Thread(() -> {
//				// 获取当前时间
////				Calendar now = Calendar.getInstance();
////				int currentHour = now.get(Calendar.HOUR_OF_DAY);
////
////				// 计算延迟时间（距离下一次12点的小时数）
////				int delayHours;
////				if (currentHour >= 12) {
////					delayHours = 24 - currentHour + 12;
////				} else {
////					delayHours = 12 - currentHour;
////				}
////
////				// 设置定时器，在延迟时间后执行线程的逻辑代码
////				Timer timer = new Timer();
////				timer.schedule(new TimerTask() {
////					@Override
////					public void run() {
////						// 线程的逻辑代码，发送信息
////						System.out.println("Sending message at 12:00 AM");
////					}
////				}, delayHours * 60 * 60 * 1000); // 将延迟时间转换为毫秒
//				// 在线程中调用另一个启动类的方法
//				// 在线程中调用StartPmm启动类的方法
//				// 获取当前时间
//				Calendar now = Calendar.getInstance();
//
//// 在线程中调用StartPmm启动类的方法
//				PmmRemindDTO4List dto = new PmmRemindDTO4List();
//				dto.setPageNo(1);
//				dto.setPageSize(10);
//				DataGrid<PmmRemindVO> dataGrid = pmmRemindService.listRemind(dto);
//				if (dataGrid != null && dataGrid.getRows() != null) {
//					for (int i = 0; i < dataGrid.getRows().size(); i++) {
//						PmmRemindVO remind = dataGrid.getRows().get(i);
//						Date createDate = remind.getCreateDate();
//						Calendar createCal = Calendar.getInstance();
//						createCal.setTime(createDate);
//
//						// 计算两个日期之间的天数差
//						long diff = Math.abs(now.getTimeInMillis() - createCal.getTimeInMillis());
//						long diffDays = diff / (24 * 60 * 60 * 1000);
//
//						// 判断是否小于15天
//						if (diffDays < 15) {
//							String message = "客户" + remind.getCustId()+ "的理财产品\"" + "\"还有" + diffDays + "天到期";
//							System.out.println(message);
//
//							// 存入天数
//							PmmRemindDTO4Update updateDto = new PmmRemindDTO4Update();
//							updateDto.setRemindContent(message);
//							pmmRemindService.updateRemind(updateDto);
//						}
//					}
//				}
//			});
//			thread.start();
//		}
//	}
}
