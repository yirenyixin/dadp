package com.gientech.sys.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.view.Tree;
import com.gientech.core.base.BaseService;
import com.gientech.core.redis.RedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * 机构--Service
 * 
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysOrgService extends BaseService<SysOrgMapper, SysOrg> {

	@Autowired
	RedisService redisService;

	/**
	 * 【1】树形List
	 * 
	 * @param topOrgId
	 * @return
	 */
	public List<Tree> listOrg(String topOrgId) {
		log.info("【tree查询条件--机构】" + topOrgId);

		QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByAsc("SORT_NO");

		// 【1】查出所有机构
		List<SysOrg> allOrgList = this.list(queryWrapper);

		List<SysOrg> list = new ArrayList<SysOrg>();// 筛选出符合条件的
		if (StringUtils.isEmpty(topOrgId)) {// 显示全部节点
			list.addAll(allOrgList);
		} else {
			// 先把顶级结点放进去
			list.add(this.getById(topOrgId));

			// 再把子节点放进去
			list.addAll(this.getChildrenList(allOrgList, topOrgId));
		}

		// 【2】找到有子节点的机构
		List<Tree> list2 = new ArrayList<Tree>();
		Map<String, String> map = new HashMap<String, String>();
		for (SysOrg sysOrg : list) {
			if (StringUtils.isNotEmpty(sysOrg.getParentOrgId())) {
				map.put(sysOrg.getParentOrgId(), sysOrg.getParentOrgId());
			}
		}

		// 【3】组织tree结构
		for (SysOrg sysOrg : list) {
			Tree tree = new Tree();

			tree.setId(sysOrg.getOrgId());
			tree.setName(sysOrg.getOrgName());
			tree.setParentId(sysOrg.getParentOrgId());
			tree.setHasChild(map.containsKey(sysOrg.getOrgId()));// 是否有子节点
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
	public void saveOrg(SysOrgDTO4Save dto) {
		log.info("【新增--机构】" + dto);

		// 【1】 从dto中copy属性
		SysOrg sysOrg = new SysOrg();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysOrg);

		// 【2】 校验id是否存在
		if (isExistOrgId(sysOrg.getOrgId())) {
			throw new AppException("新增失败，机构ID【" + sysOrg.getOrgId() + "】已经存在！");
		}

		// 【3】处理level和levelCode级次码，父节点为空，则为1级机构
		if (StringUtils.isEmpty(sysOrg.getParentOrgId())) {
			sysOrg.setOrgLevel(1);
			sysOrg.setOrgLevelCode("/" + sysOrg.getOrgId());
		} else {
			SysOrg parentSysOrg = this.getById(sysOrg.getParentOrgId());
			if (parentSysOrg == null) {
				throw new AppException("新增失败,父机构ID【" + sysOrg.getParentOrgId() + "】不存在!");
			}
			sysOrg.setOrgLevel(parentSysOrg.getOrgLevel() + 1);
			sysOrg.setOrgLevelCode(parentSysOrg.getOrgLevelCode() + "/" + sysOrg.getOrgId());
		}

		sysOrg.setVer(1);// 数据版本
		this.save(sysOrg);
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysOrg
	 */
	public void updateOrg(SysOrgDTO4Update dto) {
		log.info("【修改--机构】" + dto);

		// 【1】 从dto中copy属性
		SysOrg sysOrg = new SysOrg();
		MyBeanUtil.copyPropertiesIgnoreNull(dto, sysOrg);

		// 【2】 修改的时候，父id不能改。因为会影响level的计算
		SysOrg oldSysOrg = this.getById(sysOrg.getOrgId());
		if (StringUtils.isEmpty(oldSysOrg.getParentOrgId())) {
			if (StringUtils.isNotEmpty(sysOrg.getParentOrgId())) {// 前台传参父ID，不空的话，说明修改了。
				throw new AppException("修改失败，不能修改父机构ID!");
			}
		} else {
			if (!oldSysOrg.getParentOrgId().equals(sysOrg.getParentOrgId())) {
				throw new AppException("修改失败，不能修改父机构ID!");
			}
		}

		// 【3】处理level和levelCode级次码，父节点为空，则为1级机构
		if (StringUtils.isEmpty(sysOrg.getParentOrgId())) {
			sysOrg.setOrgLevel(1);
			sysOrg.setOrgLevelCode("/" + sysOrg.getOrgId());
		} else {
			SysOrg parentSysOrg = this.getById(sysOrg.getParentOrgId());
			if (parentSysOrg == null) {
				throw new AppException("修改失败,父机构ID【" + sysOrg.getParentOrgId() + "】不存在!");
			}
			sysOrg.setOrgLevel(parentSysOrg.getOrgLevel() + 1);
			sysOrg.setOrgLevelCode(parentSysOrg.getOrgLevelCode() + "/" + sysOrg.getOrgId());
		}

		if (!this.updateById(sysOrg)) {
			throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
		}
	}

	/**
	 * 【4】删除
	 * 
	 * @param orgId
	 */
	public void deleteOrg(String orgId) {
		log.info("【删除--机构】" + orgId);

		QueryWrapper<SysOrg> wrapper = new QueryWrapper<>();
		wrapper.eq("PARENT_ORG_ID", orgId);
		List<SysOrg> list = this.list(wrapper);
		if (list.size() > 0) {
			throw new AppException("删除失败，机构ID【" + orgId + "】存在下级机构，请先删除子机构！");
		}

		this.removeById(orgId);
	}

	/**
	 * 【5】根据Id获取对象
	 * 
	 * @param orgId 主键ID
	 * @return
	 * @throws AppException
	 */
	public SysOrg getOrg(String orgId) throws AppException {
		log.info("【获取单个--机构】" + orgId);

		return this.getById(orgId);
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

	/**
	 * 【21】检查OrgId是否存在
	 * 
	 * @param orgId
	 * @return
	 */
	private boolean isExistOrgId(String orgId) {
		return this.getById(orgId) != null;
	}

	/**
	 * 【22】递归获取所有的子节点，
	 * 
	 * @param allOrgList  所有的节点list
	 * @param parentOrgId 父节点id
	 * @return
	 */
	private List<SysOrg> getChildrenList(List<SysOrg> allOrgList, String parentOrgId) {
		List<SysOrg> list = new ArrayList<SysOrg>();

		// 循环所有Org
		for (SysOrg sysOrg : allOrgList) {
			if (parentOrgId.equals(sysOrg.getParentOrgId())) {// 说明是一级节点
				list.add(sysOrg);

				list.addAll(getChildrenList(allOrgList, sysOrg.getOrgId()));
			}
		}

		return list;
	}

}
