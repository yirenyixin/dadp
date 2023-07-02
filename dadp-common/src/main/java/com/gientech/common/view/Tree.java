package com.gientech.common.view;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * tree树形格式
 * 
 * @author 胡砥峰
 */
@Data
public class Tree implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "节点的id", position = 1)
	private String id; // 节点的id.【如:orgId】

	@ApiModelProperty(value = "显示的节点文字", position = 2)
	private String name;// 显示的节点文字.【如:orgName】

	@ApiModelProperty(value = "父节点的 id", position = 3)
	private String parentId; // 父节点的 id【如:parentOrgId】

	@ApiModelProperty(value = "是否有子节点", position = 4)
	private boolean hasChild;// 是否有子节点

	@ApiModelProperty(value = "带checkbox的树,节点是否被选中.", position = 5)
	private boolean check;// 带checkbox的树,节点是否被选中.

	@ApiModelProperty(value = "是否展开节点", position = 6)
	private boolean open;// 是否展开节点

}
