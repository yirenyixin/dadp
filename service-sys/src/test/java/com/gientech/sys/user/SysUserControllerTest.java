//package com.gientech.sys.user;
//
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.alibaba.fastjson.JSONObject;
//import com.gientech.common.BaseControllerTest;
//
///**
// * controller 层单元测试 demo <br>
// * 如果报权限问题，注释掉PreAuthorizeAspect 中的权限验证
// *
// * @author xiaoyiwu
// */
//
//public class SysUserControllerTest extends BaseControllerTest {
//	@Autowired
//	private SysUserController sysUserController;
//
//	/**
//	 * 初始化MockMvc
//	 */
//	@Override
//	@BeforeAll
//	public void setup() {
//		System.out.println("开始测试...");
//		mockMvc = MockMvcBuilders.standaloneSetup(sysUserController).build();
//	}
//
//	/**
//	 * 查询测试
//	 */
//	@Test
//	public void list() throws Exception {
//		SysUserDTO4List list = new SysUserDTO4List();
//		list.setPageNo(1);
//		list.setPageSize(10);
//
//		// 设置入参 针对入参是 @RequestBody 类型的
//		String requestJson = JSONObject.toJSONString(list);
//		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/sys/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson).content(requestJson).header("Authorization", "91ba4f87-9b06-4416-898c-0f6fd08c6d8f"));
//		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
//		resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//		// MockMvcResultHandlers.print() 方法会输出结果。mvcResult.getResponse()可以拿到mock返回的结果，做进一步判断
//		System.out.println("List测试结果>>>>" + resultActions.andReturn().getResponse().getContentAsString());
//	}
//
//	/**
//	 * 新增测试
//	 */
//	@Test
//	public void save() throws Exception {
//		SysUserDTO4Save save = new SysUserDTO4Save();
//		save.setUserId("test2");
//		save.setUserName("test测试");
//		save.setLoginName("test1");
//		save.setTel("13131313131");
//		save.setPassword("123456");
//		save.setSex("1");
//		save.setOrgId("999");
////        save.setOrgId("992");
////        save.setLawOrgId("933");
//		save.setRoleId("test");
//		save.setRoleIds("test,admin,002005");
//		save.setStatus("1");
//		save.setSortNo(1);
//
//		// 设置入参 针对入参是 @RequestBody 类型的
//		String requestJson = JSONObject.toJSONString(save);
//		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/sys/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson).content(requestJson).header("Authorization", "91ba4f87-9b06-4416-898c-0f6fd08c6d8f"));
//		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
//		resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//		// MockMvcResultHandlers.print() 方法会输出结果。mvcResult.getResponse()可以拿到mock返回的结果，做进一步判断
//		System.out.println("保存测试结果>>>>" + resultActions.andReturn().getResponse().getContentAsString());
//
//	}
//
//	/**
//	 * 修改测试
//	 */
//
//	@Test
//	public void update() throws Exception {
//		SysUserDTO4Update update = new SysUserDTO4Update();
//		update.setUserId("test2");
//		update.setUserName("aaa");
//		update.setLoginName("aaa");
//		update.setTel("3131313131");
//		update.setPassword("54321");
//		update.setSex("1");
//		update.setOrgId("999");
//		update.setRoleId("test");
//		update.setRoleIds("test,admin,002005");
//		update.setStatus("1");
//		update.setSortNo(1);
//		update.setVer(1);
//
//		// 设置入参 针对入参是 @RequestBody 类型的
//		String requestJson = JSONObject.toJSONString(update);
//		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/sys/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson).content(requestJson).header("Authorization", "91ba4f87-9b06-4416-898c-0f6fd08c6d8f"));
//		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
//		resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//		// MockMvcResultHandlers.print() 方法会输出结果。mvcResult.getResponse()可以拿到mock返回的结果，做进一步判断
//		System.out.println("修改测试>>>>" + resultActions.andReturn().getResponse().getContentAsString());
//	}
//
//	/**
//	 * 删除测试
//	 */
//	@Test
//	public void delete() throws Exception {
//		SysUserDTO4Delete delete = new SysUserDTO4Delete();
//		delete.setUserIds("test2");
//
//		// 设置入参 针对入参是 @RequestBody 类型的
//		String requestJson = JSONObject.toJSONString(delete);
//		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/sys/user/delete").contentType(MediaType.APPLICATION_JSON).content(requestJson).header("Authorization", "91ba4f87-9b06-4416-898c-0f6fd08c6d8f"));
//		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
//		resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//		// MockMvcResultHandlers.print() 方法会输出结果。mvcResult.getResponse()可以拿到mock返回的结果，做进一步判断
//		System.out.println("删除结果>>>>" + resultActions.andReturn().getResponse().getContentAsString());
//	}
//}
