package com.gientech.sys.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gientech.common.view.DataGrid;

/**
 * service 层单元测试
 *
 * @author luorendong
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class SysUserServiceTest {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 查询
	 */
	@Test
	public void list() {
		SysUserDTO4List sysUserDTO4List = new SysUserDTO4List();
		sysUserDTO4List.setPageNo(1);
		sysUserDTO4List.setPageSize(10);

		DataGrid<SysUserVO> dataGrid = sysUserService.listUser(sysUserDTO4List);
		if (dataGrid != null && dataGrid.getRows() != null) {
			for (int i = 0; i < dataGrid.getRows().size(); i++) {
				System.out.println("222222:" + dataGrid.getRows().get(i));
			}
		}
	}

	/**
	 * 新增
	 */
	@Test
	public void save() {
		SysUserDTO4Save sysUserDTO4Save = new SysUserDTO4Save();
		sysUserDTO4Save.setUserId("Test");
		sysUserDTO4Save.setUserName("Test");
		sysUserDTO4Save.setLoginName("Test");
		sysUserDTO4Save.setTel("51146156448");
		sysUserDTO4Save.setPassword("123568");
		sysUserDTO4Save.setSex("1");
		sysUserDTO4Save.setOrgId("888");
		sysUserDTO4Save.setRoleId("test");
		sysUserDTO4Save.setRoleIds("test,admin,002005");
		sysUserDTO4Save.setStatus("1");
		sysUserDTO4Save.setSortNo(1);

		sysUserService.saveUser(sysUserDTO4Save);
	}

	@Test
	public void update() {
		SysUserDTO4Update sysUserDTO4Update = new SysUserDTO4Update();
		sysUserDTO4Update.setUserId("Test");
//        sysUserDTO4Update.setUserId("test2");
		sysUserDTO4Update.setUserName("abc");
		sysUserDTO4Update.setLoginName("abc");
		sysUserDTO4Update.setTel("5133553542");
		sysUserDTO4Update.setPassword("541267");
		sysUserDTO4Update.setSex("1");
		sysUserDTO4Update.setOrgId("888");
		sysUserDTO4Update.setRoleId("test2");
		sysUserDTO4Update.setRoleIds("test,admmn,002005");
		sysUserDTO4Update.setStatus("1");
		sysUserDTO4Update.setSortNo(1);
		sysUserDTO4Update.setVer(1);

		sysUserService.updateUser(sysUserDTO4Update);
	}

	/**
	 * 删除
	 */
	@Test
	public void delete() {
		String userId = "Test";
		sysUserService.deleteUser(userId);
	}
}
