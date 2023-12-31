package com.gientech.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关启动程序
 * 
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class StartGateway {
	public static void main(String[] args) {
		SpringApplication.run(StartGateway.class, args);
		System.out.println("---------------网关启动成功---------------");
	}
}
