package com.gientech.sys.codeType;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 代码类别实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_CODE_TYPE")
public class SysCodeType implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "CODE_TYPE_ID", type = IdType.INPUT)
	private String codeTypeId;// 代码类别ID

	@TableField(value = "CODE_TYPE_NAME")
	private String codeTypeName;// 代码类别名称

	@TableField(value = "SORT_NO")
	private Integer sortNo;// 排序号

	@TableField(value = "IS_PINYIN")
	private String isPinyin;// 是否拼音排序

	@TableField(value = "REMARK")
	private String remark;// 备注

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}