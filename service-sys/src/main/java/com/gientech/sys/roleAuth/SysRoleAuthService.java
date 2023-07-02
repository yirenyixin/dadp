package com.gientech.sys.roleAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gientech.common.MyConstants;
import com.gientech.common.auth.UserSession;
import com.gientech.common.view.Tree;
import com.gientech.core.base.BaseService;
import com.gientech.sys.func.SysFunc;
import com.gientech.sys.func.SysFuncService;
import com.gientech.sys.menu.SysMenu;
import com.gientech.sys.menu.SysMenuService;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 操作权限--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysRoleAuthService extends BaseService<SysRoleAuthMapper, SysRoleAuth> {

	@Autowired
	private SysMenuService sysMenuService;

	@Autowired
	private SysFuncService sysFuncService;

	/**
	 * 【1】根据roleId获取菜单和功能tree，用于角色授权
	 *
	 * @param roleId
	 * @return
	 */
	public List<Tree> listRoleAuth(String roleId) {
		log.info("【查询角色拥有的权限--tree】" + roleId);

		List<Tree> list = new ArrayList<Tree>();

		// 【1】读取所有的menu列表和func列表
		List<SysMenu> menuList = this.sysMenuService.list();
		List<SysFunc> funcList = this.sysFuncService.list();

		// 【2】根据roleId读取拥有的权限。
		QueryWrapper<SysRoleAuth> roleAuthWrapper = new QueryWrapper<SysRoleAuth>();
		roleAuthWrapper.eq("ROLE_ID", roleId);
		List<SysRoleAuth> roleAuthList = this.list(roleAuthWrapper);

		// 【3】当前roleId拥有的权限map
		Map<String, String> roleAuthMap = new HashMap<String, String>();
		for (SysRoleAuth sysRoleAuth : roleAuthList) {
			roleAuthMap.put(sysRoleAuth.getMenuOrFuncId(), sysRoleAuth.getMenuOrFuncId());
		}

		// 【4】当前操作人是admin给其他角色授权，显示所有。非admin给其他角色授权，显示本人拥有的权限。
		UserSession userSession = this.getUserSession();
		if (!userSession.isAdmin()) {
			// 不是admin在授权， 可授权的就只是本人拥有的menu。
			List<SysMenu> noAuthMenuList = new ArrayList<SysMenu>();
			for (SysMenu sysMenu : menuList) {
				if (!roleAuthMap.containsKey(sysMenu.getMenuId())) {// 该角色没有这个menu
					noAuthMenuList.add(sysMenu);
				}
			}
			menuList.removeAll(noAuthMenuList);// 移除没有权限的menu

			// 不是admin在授权， 可授权的就只是本人拥有的func。
			List<SysFunc> noAuthFuncList = new ArrayList<SysFunc>();
			for (SysFunc sysFunc : funcList) {
				if (!roleAuthMap.containsKey(sysFunc.getFuncId())) {// 该角色没有这个func
					noAuthFuncList.add(sysFunc);
				}
			}
			funcList.removeAll(noAuthFuncList);// 移除没有权限的func
		}

		// 【5】所有父节点ID组成map，后面组织Tree要用
		Map<String, String> parentIdMap = new HashMap<String, String>();
		for (SysMenu sysMenu : menuList) {
			if (StringUtils.isNotEmpty(sysMenu.getParentMenuId())) {
				parentIdMap.put(sysMenu.getParentMenuId(), sysMenu.getParentMenuId());
			}
		}

		for (SysFunc sysFunc : funcList) {
			parentIdMap.put(sysFunc.getMenuId(), sysFunc.getMenuId());// 在func中的menuId，都是有子节点的
		}

		// 【6】把剩余的menuList和funcList拼成1个tree。被授权角色是admin，全部勾选。非admin按已有权限勾选
		for (SysMenu sysMenu : menuList) {
			Tree tree = new Tree();

			tree.setId(sysMenu.getMenuId());
			tree.setName(sysMenu.getMenuName());
			tree.setParentId(sysMenu.getParentMenuId());
			tree.setHasChild(parentIdMap.containsKey(sysMenu.getMenuId()));// 是否有子节点
			if (tree.isHasChild()) {
				tree.setOpen(true);
			}
			tree.setCheck(roleAuthMap.containsKey(sysMenu.getMenuId()));// 是否勾选

			list.add(tree);
		}

		for (SysFunc sysFunc : funcList) {
			Tree tree = new Tree();

			tree.setId(sysFunc.getFuncId());
			tree.setName(sysFunc.getFuncName());
			tree.setParentId(sysFunc.getMenuId());
			tree.setHasChild(false);// func肯定没有子节点
			tree.setOpen(false);
			tree.setCheck(roleAuthMap.containsKey(sysFunc.getFuncId()));// 是否勾选

			list.add(tree);
		}

		return list;
	}

	/**
	 * 【2】保存--被授权角色的操作权限
	 *
	 * @param dto
	 */
	public void saveRoleAuth(SysRoleAuthDTO4Save dto) {
		log.info("【保存--角色授权】" + dto);

		String roleId = dto.getRoleId();

		// 【1】先删除此角色的已有操作权限
		QueryWrapper<SysRoleAuth> roleAuthWrapper = new QueryWrapper<SysRoleAuth>();
		roleAuthWrapper.eq("ROLE_ID", roleId);
		this.remove(roleAuthWrapper);

		// 【2】准备菜单id的map，不是菜单就是func
		Map<String, String> menuMap = new HashMap<String, String>();
		List<SysMenu> menuList = this.sysMenuService.list();
		for (SysMenu sysMenu : menuList) {
			menuMap.put(sysMenu.getMenuId(), sysMenu.getMenuId());
		}

		// 【3】保存新的操作权限
		String[] menuOrFuncIdArray = StrUtil.splitToArray(dto.getMenuOrFuncIds(), ",");
		for (String menuOrFuncId : menuOrFuncIdArray) {
			SysRoleAuth sysRoleAuth = new SysRoleAuth();

			sysRoleAuth.setRoleId(roleId);
			sysRoleAuth.setAuthType(menuMap.containsKey(menuOrFuncId) ? MyConstants.OPER_TYPE_01 : MyConstants.OPER_TYPE_02);
			sysRoleAuth.setMenuOrFuncId(menuOrFuncId);

			this.save(sysRoleAuth);
		}
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

}
