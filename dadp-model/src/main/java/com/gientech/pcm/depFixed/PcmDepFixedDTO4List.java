package com.gientech.pcm.depFixed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "对私定期存款--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" }) // 字段不接受前台传参，防止sql注入
public class PcmDepFixedDTO4List implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", required = true, position = 1)
    @NotNull(message = "[pageNo]当前页码，不能为空")
    @Min(value = 1, message = "[pageNo]当前页码，不能小于1")
    @Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
    private Integer pageNo; // 当前页码

    @ApiModelProperty(value = "每页大小", required = true, position = 2)
    @NotNull(message = "[pageSize]每页大小，不能为空")
    @Min(value = 1, message = "[pageSize]每页大小，不能小于1")
    @Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
    private Integer pageSize; // 每页大小

    @ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
    private String sort; // 排序字段名,多个逗号分隔

    @ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
    private String order; // 按什么排序(asc,desc)

    @JsonIgnore
    private String orderBy; // 排序sql片段

    // -----------------分割线---------------------------------------

    @ApiModelProperty(value = "ID", position = 13)
    private String depFixedId; // ID

    @ApiModelProperty(value = "客户ID", position = 14)
    private String custId; // 客户ID

    @ApiModelProperty(value = "ECIF客户ID", position = 15)
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "客户名称", position = 16)
    private String custName; // 客户名称

    @ApiModelProperty(value = "法人机构号", position = 17)
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "产品代码", position = 18)
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "产品名称", position = 19)
    private String prodName; // 产品名称

    @ApiModelProperty(value = "账号", position = 20)
    private String acctNo; // 账号

    @ApiModelProperty(value = "子账号", position = 21)
    private String subAcctNo; // 子账号

    @ApiModelProperty(value = "存款类型", position = 22)
    private String acctType; // 存款类型

    @ApiModelProperty(value = "浮动比率", position = 23)
    private Double floatRate; // 浮动比率

    @ApiModelProperty(value = "协议利率", position = 24)
    private Double rate; // 协议利率

    @ApiModelProperty(value = "币种", position = 25)
    private String currNo; // 币种

    @ApiModelProperty(value = "上日余额", position = 26)
    private Double bal; // 上日余额

    @ApiModelProperty(value = "存期", position = 27)
    private String term; // 存期

    @ApiModelProperty(value = "到期日期", position = 28)
    private String endDate; // 到期日期

    @ApiModelProperty(value = "账户状态", position = 29)
    private String acctSts; // 账户状态

    @ApiModelProperty(value = "开户机构号", position = 30)
    private String openOrgNo; // 开户机构号

    @ApiModelProperty(value = "起存日期", position = 31)
    private String startDt; // 起存日期

    @ApiModelProperty(value = "凭证号", position = 32)
    private String voucherNo; // 凭证号






    // -----------------分割线---------------------------------------




    @ApiModelProperty(value = "持有类型", position = 33)
    private String isHis; // 是否历史持有  0当前  1 历史

    @ApiModelProperty(value = "当前日期", position = 34)
    private String nowDate;

}