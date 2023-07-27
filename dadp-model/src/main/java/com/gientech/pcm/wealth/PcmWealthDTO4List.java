package com.gientech.pcm.wealth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cjm
 * @date 2023/7/7 19:15
 */
@Data
@ApiModel(value = "对私理财--查询条件的DTO类")
@JsonIgnoreProperties(value = {"orderBy"})// 字段不接受前台传参，防止sql注入
public class PcmWealthDTO4List implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", required = true, position = 1)
    @NotNull(message = "[pageNo]当前页码，不能为空")
    @Min(value = 1, message = "[pageNo]当前页码，不能小于1")
    @Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
    private Integer pageNo;// 当前页码

    @ApiModelProperty(value = "每页大小", required = true, position = 2)
    @NotNull(message = "[pageSize]每页大小，不能为空")
    @Min(value = 1, message = "[pageSize]每页大小，不能小于1")
    @Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
    private Integer pageSize;// 每页大小

    @ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
    private String sort;// 排序字段名,多个逗号分隔

    @ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
    private String order;// 按什么排序(asc,desc)

    @JsonIgnore
    private String orderBy;// 排序sql片段

    // -----------------分割线---------------------------------------
    @ApiModelProperty(value = "ID", position = 5)
    private String wealthId;

    @ApiModelProperty(value = "客户ID", position = 6)
    private String custId;

    @ApiModelProperty(value = "ECIF客户ID", position = 7)
    private String ecifCustId;

    @ApiModelProperty(value = "客户名称", position = 8)
    private String custName;

    @ApiModelProperty(value = "法人机构号", position = 9)
    private String lawOrgId;
    @ApiModelProperty(value = "开户机构ID",  position = 10)
    private String openOrgId; // 开户机构ID

    @ApiModelProperty(value = "产品代码",  position = 11)
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "产品名称",  position = 12)
    private String prodName; // 产品名称

    @ApiModelProperty(value = "产品类型",  position = 13)
    private String prodType; // 产品类型

    @ApiModelProperty(value = "风险级别",  position = 14)
    private String riskLevel; // 风险级别

    @ApiModelProperty(value = "发行方", position = 15)
    private String publicOrg; // 发行方

    @ApiModelProperty(value = "业绩比较基准", position = 16)
    private BigDecimal perfCompareBase; // 业绩比较基准

    @ApiModelProperty(value = "当前余额", position = 17)
    private BigDecimal currentBal; // 当前余额

    @ApiModelProperty(value = "起息日期",  position = 18)
    private String interestDate; // 起息日期

    @ApiModelProperty(value = "到期日期", position = 19)
    private String endDate; // 到期日期

    @ApiModelProperty(value = "持有收益",  position = 20)
    private BigDecimal holdProfit; // 持有收益

    @ApiModelProperty(value = "持有收益率", position = 21)
    private BigDecimal holdProfitRate; // 持有收益率



    @ApiModelProperty(value = "持有类型", position = 22)
    private String isHis; // 是否历史持有  0当前  1 历史

    @ApiModelProperty(value = "当前日期", position = 23)
    private String nowDate;
}