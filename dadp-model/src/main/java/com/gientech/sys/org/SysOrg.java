package com.gientech.sys.org;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 机构实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_ORG")
public class SysOrg implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ORG_ID", type = IdType.INPUT)
	private String orgId;// 机构ID

	@TableField(value = "ORG_NAME")
	private String orgName;// 机构名称

	@TableField(value = "PARENT_ORG_ID")
	private String parentOrgId;// 上级机构ID

	@TableField(value = "ORG_LEVEL")
	private Integer orgLevel;// 机构级次

	@TableField(value = "ORG_LEVEL_CODE")
	private String orgLevelCode;// 机构级次码

	@TableField(value = "SORT_NO")
	private Integer sortNo;// 排序号

	@TableField(value = "REMARK")
	private String remark;// 备注

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}