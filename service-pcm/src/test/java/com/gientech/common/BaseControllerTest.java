package com.gientech.common;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BaseControllerTest {
	public MockMvc mockMvc;

	@Before
	public void setup() {
		System.out.println("开始测试...");
	}

	@After
	public void after() {
		System.out.println("测试结束...");
	}
}
