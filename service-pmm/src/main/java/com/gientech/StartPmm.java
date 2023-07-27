package com.gientech;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class StartPmm {

	public static void main(String[] args) {
		SpringApplication.run(StartPmm.class, args);
		System.out.println("---------------pmm启动成功---------------");
	}


}