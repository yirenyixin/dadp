package com.gientech.sys.config;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 系统参数实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_CONFIG")
public class SysConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "CONFIG_ID", type = IdType.INPUT)
	private String configId;// 系统参数ID

	@TableField(value = "CONFIG_NAME")
	private String configName;// 系统参数名称

	@TableField(value = "CONFIG_VALUE")
	private String configValue;// 系统参数值

	@TableField(value = "SORT_NO")
	private Integer sortNo;// 排序号

	@TableField(value = "REMARK")
	private String remark;// 备注

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}