package com.gientech.sys.user;

import com.gientech.common.view.DataGrid;
import com.gientech.sys.user.*;
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
		SysUserDTO4Save dto = new SysUserDTO4Save();
		dto.setUserId("Test");
		dto.setUserName("Test UserName");
		dto.setLoginName("Test LoginName");
		dto.setTel("Test Tel");
		dto.setPassword("Test Password");
		dto.setSex("M");
		dto.setOrgId("Test OrgId");
		dto.setOrgAddr("Test OrgAddr");
		dto.setLawOrgId("Test LawOrgId");
		dto.setIdCardNo("Test IDCardNo");
		dto.setAddr("Test Addr");
		dto.setEmail("Test Email");
		dto.setTellerNo("Test TellerNo");
		dto.setWorkingYears(5);
		dto.setWechatNo("Test WechatNo");
		dto.setRoleId("Test RoleId");
		dto.setRoleIds("Test RoleIds");
		dto.setStatus("1");
		dto.setSortNo(1);
		dto.setRemark("Test Remark");
		dto.setVer(1);

		sysUserService.saveSysUser(dto);
	}

	/**
	 * 修改 SysUser
	 */
	@Test
	public void update() {
		SysUserDTO4Update dto = new SysUserDTO4Update();
		dto.setUserId("Test");
		dto.setUserName("Updated UserName");
		dto.setLoginName("Updated LoginName");
		// Set other properties

		sysUserService.updateSysUser(dto);
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