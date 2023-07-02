package com.gientech.sys.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gientech.common.auth.UserSession;
import com.gientech.common.enums.YesOrNo;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.view.Tree;
import com.gientech.core.base.BaseService;
import com.gientech.sys.func.SysFunc;
import com.gientech.sys.func.SysFuncService;

import lombok.extern.slf4j.Slf4j;

/**
 * 菜单--Service
 *
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysMenuService extends BaseService<SysMenuMapper, SysMenu> {

	@Autowired
	private SysFuncService sysFuncService;

	/**
	 * 【1】树形List
	 *
	 * @param topMenuId
	 * @return
	 */
	public List<Tree> listMenu(String topMenuId) {
		log.info("【tree查询条件--菜单】" + topMenuId);

		QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByAsc("SORT_NO");

		// 【1】查出所有菜单
		List<SysMenu> allMenuList = this.list(queryWrapper);

		List<SysMenu> list = new ArrayList<SysMenu>();// 筛选出符合条件的
		if (StringUtils.isEmpty(topMenuId)) {// 显示全部节点
			list.addAll(allMenuList);
		} else {
			// 先把顶级结点放进去
			list.add(this.getById(topMenuId));

			// 再把子节点放进去
			list.addAll(this.getChildrenList(allMenuList, topMenuId));
		}

		// 【2】找到有子节点的菜单
		List<Tree> list2 = new ArrayList<Tree>();
		Map<String, String> map = new HashMap<String, String>();
		for (SysMenu sysMenu : list) {
			if (StringUtils.isNotEmpty(sysMenu.getParentMenuId())) {
				map.put(sysMenu.getParentMenuId(), sysMenu.getParentMenuId());
			}
		}

		// 【3】组织tree结构
		for (SysMenu sysMenu : list) {
			Tree tree = new Tree();

			tree.setId(sysMenu.getMenuId());
			tree.setName(sysMenu.getMenuName());
			tree.setParentId(sysMenu.getParentMenuId());
			tree.setHasChild(map.containsKey(sysMenu.getMenuId()));// 是否有子节点
			if (tree.isHasChild()) {
				tree.setOpen(true);
			}

			list2.add(tree);
		}

		return list2;
	}

	/**
	 * 【2】新增--保存
	 *
	 * @param dto
	 */
	public void saveMenu(SysMenuDTO4Save dto) {
		log.info("【新增--菜单】" + dto);

		// 【1】 从dto中copy属性
		SysMenu sysMenu = new SysMenu();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysMenu);

		// 【2】 校验id是否存在
		if (isExistMenuId(sysMenu.getMenuId())) {
			throw new AppException("新增失败，菜单ID【" + sysMenu.getMenuId() + "】已经存在！");
		}

		sysMenu.setVer(1);// 数据版本
		this.save(sysMenu);
	}

	/**
	 * 【3】修改
	 *
	 * @param dto
	 */
	public void updateMenu(SysMenuDTO4Update dto) {
		log.info("【修改--菜单】" + dto);

		// 【1】 从dto中copy属性
		SysMenu sysMenu = new SysMenu();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysMenu);

		if (!this.updateById(sysMenu)) {
			throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
		}
	}

	/**
	 * 【4】删除
	 *
	 * @param menuId
	 */
	public void deleteMenu(String menuId) {
		log.info("【删除--菜单】" + menuId);

		QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
		wrapper.eq("PARENT_MENU_ID", menuId);
		List<SysMenu> list = this.list(wrapper);
		if (list.size() > 0) {
			throw new AppException("删除失败，菜单ID【" + menuId + "】存在下级菜单，请先删除子菜单！");
		}

		this.removeById(menuId);

		// 【2】删除子表
		QueryWrapper<SysFunc> funcWrapper = new QueryWrapper<>();
		funcWrapper.eq("MENU_ID", menuId);
		this.sysFuncService.remove(funcWrapper);
	}

	/**
	 * 【5】根据Id获取对象
	 *
	 * @param menuId 主键ID
	 * @return
	 * @throws AppException
	 */
	public SysMenu getMenu(String menuId) throws AppException {
		log.info("【获取单个--菜单】" + menuId);

		return this.getById(menuId);
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

	/**
	 * 【21】检查MenuId是否存在
	 *
	 * @param menuId
	 * @return
	 */
	public boolean isExistMenuId(String menuId) {
		return this.getById(menuId) != null;
	}

	/**
	 * 【22】递归获取所有的子节点，
	 *
	 * @param allMenuList  所有的节点list
	 * @param parentMenuId 父节点id
	 * @return
	 */
	private List<SysMenu> getChildrenList(List<SysMenu> allMenuList, String parentMenuId) {
		List<SysMenu> list = new ArrayList<SysMenu>();

		// 循环所有Menu
		for (SysMenu sysMenu : allMenuList) {
			if (parentMenuId.equals(sysMenu.getParentMenuId())) {// 说明是一级节点
				list.add(sysMenu);

				list.addAll(getChildrenList(allMenuList, sysMenu.getMenuId()));
			}
		}

		return list;
	}

	/**
	 * 【11】获取当前用户拥有的菜单列表
	 *
	 * @return
	 */
	public List<SysMenu> listMenuByAuth() {
		UserSession userSession = this.getUserSession();

		// 【1】查出所有菜单
		QueryWrapper<SysMenu> menuWrapper = new QueryWrapper<>();
		menuWrapper.orderByAsc("SORT_NO");
		menuWrapper.eq("IS_SHOW", YesOrNo.YES.getValue());
		List<SysMenu> allMenuList = this.list(menuWrapper);

		// 【2】admin有所有菜单，非admin显示自己的菜单
		if (userSession.isAdmin()) {
			return allMenuList;
		} else {
			// 【2】查出当前roleId拥有的菜单
			List<SysMenu> myMenuList = new ArrayList<SysMenu>();
			for (SysMenu sysMenu : allMenuList) {
				if (userSession.getAuths().contains(sysMenu.getMenuId())) {
					myMenuList.add(sysMenu);
				}
			}

			return myMenuList;
		}
	}
}
