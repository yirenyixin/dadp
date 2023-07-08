package com.gientech.sys.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "T_SYS_USER")
public class SysUser {

	@TableId(value = "USER_ID")
	private String userId; // 用户ID

	@TableField(value = "USER_NAME")
	private String userName; // 用户姓名

	@TableField(value = "LOGIN_NAME")
	private String loginName; // 登录名

	@TableField(value = "TEL")
	private String tel; // 手机号

	@TableField(value = "PASSWORD")
	private String password; // 密码

	@TableField(value = "SEX")
	private String sex; // 性别

	@TableField(value = "ORG_ID")
	private String orgId; // 所属机构

	@TableField(value = "ORG_ADDR")
	private String orgAddr; // 所属机构地址

	@TableField(value = "LAW_ORG_ID")
	private String lawOrgId; // 法人机构号

	@TableField(value = "ID_CARD_NO")
	private String idCardNo; // 身份证号码

	@TableField(value = "ADDR")
	private String addr; // 联系地址

	@TableField(value = "EMAIL")
	private String email; // 邮箱

	@TableField(value = "TELLER_NO")
	private String tellerNo; // 柜员号

	@TableField(value = "WORKING_YEARS")
	private Integer workingYears; // 从业年限

	@TableField(value = "WECHAT_NO")
	private String wechatNo; // 微信号

	@TableField(value = "ROLE_ID")
	private String roleId; // 当前角色

	@TableField(value = "ROLE_IDS")
	private String roleIds; // 拥有的全部角色

	@TableField(value = "STATUS")
	private String status; // 用户状态

	@TableField(value = "SORT_NO")
	private Integer sortNo; // 排序号

	@TableField(value = "REMARK")
	private String remark; // 备注

	@TableField(value = "VER")
	private Integer ver; // 数据版本
}