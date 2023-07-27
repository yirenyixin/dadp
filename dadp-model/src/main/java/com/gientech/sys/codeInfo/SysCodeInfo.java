package com.gientech.sys.codeInfo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 代码信息实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_CODE_INFO")
public class SysCodeInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "CODE_INFO_ID", type = IdType.ASSIGN_ID)
	private String codeInfoId;// 代码信息ID

	@TableField(value = "CODE_TYPE_ID")
	private String codeTypeId;// 代码类别ID

	@TableField(value = "VALUE")
	private String value;// 下拉框值

	@TableField(value = "CONTENT")
	private String content;// 下拉框内容

	@TableField(value = "PARENT_VALUE")
	private String parentValue;// 上级联动下拉框值

	@TableField(value = "SORT_NO")
	private Integer sortNo;// 排序号

	@TableField(value = "REMARK")
	private String remark;// 备注

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}