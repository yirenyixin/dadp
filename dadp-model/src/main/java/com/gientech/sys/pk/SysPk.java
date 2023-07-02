package com.gientech.sys.pk;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 流水号主键实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_PK")
public class SysPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "PK_ID", type = IdType.ASSIGN_ID)
	private String pkId;// 自定义主键ID

	@NotBlank(message = "主键前缀不能为空")
	@Size(max = 20, message = "主键前缀的长度必须小于等于20")
	@TableField(value = "PK_PREFIX")
	private String pkPrefix;// 主键前缀

	@Size(max = 8, message = "主键日期的长度必须小于等于8")
	@TableField(value = "PK_DATE")
	private String pkDate;// 主键日期

	@NotNull(message = "最大值不能为空")
	@Min(value = 0, message = "最大值不能小于0")
	@Max(value = Integer.MAX_VALUE, message = "最大值不能大于" + Integer.MAX_VALUE)
	@TableField(value = "PK_MAX")
	private Integer pkMax;// 最大值

}