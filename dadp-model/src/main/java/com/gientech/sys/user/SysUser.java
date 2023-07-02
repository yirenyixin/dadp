package com.gientech.sys.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 用户实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_USER")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "USER_ID", type = IdType.INPUT)
	private String userId;// 用户ID

	@TableField(value = "USER_NAME")
	private String userName;// 用户姓名

	@TableField(value = "LOGIN_NAME")
	private String loginName;// 登陆名

	@TableField(value = "TEL")
	private String tel;// 手机号

	@TableField(value = "PASSWORD")
	private String password;// 密码

	@TableField(value = "SEX")
	private String sex;// 性别

	@TableField(value = "ORG_ID")
	private String orgId;// 所属机构

	@TableField(value = "ROLE_ID")
	private String roleId;// 当前角色

	@TableField(value = "ROLE_IDS")
	private String roleIds;// 拥有的全部角色

	@TableField(value = "STATUS")
	private String status;// 用户状态

	@TableField(value = "SORT_NO")
	private Integer sortNo;// 排序号

	@TableField(value = "REMARK")
	private String remark;// 备注

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}