package com.gientech.sys.user;

import com.gientech.common.view.DataGrid;
import com.gientech.sys.user.SysUser;
import com.gientech.sys.user.SysUserDTO4List;
import com.gientech.sys.user.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SysUser - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 查询和分页
	 */
	@Test
	public void list() {
		SysUserDTO4List dto = new SysUserDTO4List();
		dto.setPageNo(1);
		dto.setPageSize(10);
//		dto.setLoginName("admin");
		// Set other properties for filtering

		DataGrid<SysUserVO> dataGrid = sysUserService.listSysUser(dto);
		if (dataGrid != null && dataGrid.getRows() != null) {
			for (int i = 0; i < dataGrid.getRows().size(); i++) {
				System.out.println("SysUser: " + dataGrid.getRows().get(i));
			}
		}
	}

	/**
	 * 新增 SysUser
	 */
	@Test
	public void save() {
		SysUserDTO4Save sysUser = new SysUserDTO4Save();
		sysUser.setUserId("Test");
		sysUser.setUserName("Test User");
		sysUser.setLoginName("testuser");
		sysUser.setTel("1234567890");
		sysUser.setPassword("testpassword");
		sysUser.setSex("M");
		sysUser.setOrgId("TestOrgId");
		sysUser.setOrgAddr("Test OrgAddr");
		sysUser.setLawOrgId("TestLawOrgId");
		sysUser.setIdCardNo("TestIDCardNo");
//		sysUser.setAddr("Test Addr");
		sysUser.setEmail("test@example.com");
		sysUser.setTellerNo("TestTellerNo");
		sysUser.setWorkingYears(5);
		sysUser.setWechatNo("TestWechatNo");
		sysUser.setRoleId("TestRoleId");
		sysUser.setRoleIds("TestRoleIds");
		sysUser.setStatus("1");
		sysUser.setSortNo(1);
		sysUser.setRemark("Test Remark");
		sysUser.setVer(1);
		// Set other properties

		sysUserService.saveSysUser(sysUser);
	}

	/**
	 * 修改 SysUser
	 */
	@Test
	public void update() {
		SysUserDTO4Update sysUser = new SysUserDTO4Update();
		sysUser.setUserId("Test");
		sysUser.setUserName("Updated User");
		sysUser.setLoginName("updateduser");
		// Set other properties

		sysUserService.updateSysUser(sysUser);
	}

	/**
	 * 删除 SysUser
	 */
	@Test
	public void delete() {
		String userId = "Test";
		sysUserService.deleteSysUser(userId);
	}
}