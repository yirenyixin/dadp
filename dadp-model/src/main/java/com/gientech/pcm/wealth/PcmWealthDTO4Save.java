package com.gientech.pcm.wealth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cjm
 * @date 2023/7/7 17:23
 */

@Data
@ApiModel(value = "对私理财-新增DTO")
public class PcmWealthDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "ID", required = true, position = 1)
//    @NotBlank(message = "[wealthId]ID，不能为空")
//    @Size(max = 32, message = "ID的长度必须小于等于32")
//    private String wealthId; // ID

    @ApiModelProperty(value = "客户ID", required = false, position = 2)
    @Size(max = 32, message = "客户ID的长度必须小于等于32")
    private String custId; // 客户ID

    @ApiModelProperty(value = "ECIF客户ID", required = false, position = 3)
    @Size(max = 32, message = "ECIF客户ID的长度必须小于等于32")
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "客户姓名", required = false, position = 4)
    @Size(max = 128, message = "客户姓名的长度必须小于等于128")
    private String custName; // 客户姓名

    @ApiModelProperty(value = "法人机构ID", required = false, position = 5)
    @Size(max = 32, message = "法人机构ID的长度必须小于等于32")
    private String lawOrgId; // 法人机构ID

    @ApiModelProperty(value = "开户机构ID", required = false, position = 6)
    @Size(max = 32, message = "开户机构ID的长度必须小于等于32")
    private String openOrgId; // 开户机构ID

    @ApiModelProperty(value = "产品代码", required = false, position = 7)
    @Size(max = 32, message = "产品代码的长度必须小于等于32")
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "产品名称", required = false, position = 8)
    @Size(max = 100, message = "产品名称的长度必须小于等于100")
    private String prodName; // 产品名称

    @ApiModelProperty(value = "产品类型", required = false, position = 9)
    @Size(max = 32, message = "产品类型的长度必须小于等于32")
    private String prodType; // 产品类型

    @ApiModelProperty(value = "风险级别", required = false, position = 10)
    @Size(max = 32, message = "风险级别的长度必须小于等于32")
    private String riskLevel; // 风险级别

    @ApiModelProperty(value = "发行方", required = false, position = 11)
    @Size(max = 200, message = "发行方的长度必须小于等于200")
    private String publicOrg; // 发行方

    @ApiModelProperty(value = "业绩比较基准", required = false, position = 12)
    //@Size(max = 22, message = "业绩比较基准的长度必须小于等于22")
    private BigDecimal perfCompareBase; // 业绩比较基准

    @ApiModelProperty(value = "当前余额", required = false, position = 13)
    private BigDecimal currentBal; // 当前余额

    @ApiModelProperty(value = "起息日期", required = false, position = 14)
    @Size(max = 10, message = "起息日期的长度必须小于等于10")
    private String interestDate; // 起息日期

    @ApiModelProperty(value = "到期日期", required = false, position = 15)
    @Size(max = 10, message = "到期日的长度必须小于等于10")
    private String endDate; // 到期日期

    @ApiModelProperty(value = "持有收益", required = false, position = 16)
    private BigDecimal holdProfit; // 持有收益

    @ApiModelProperty(value = "持有收益率", required = false, position = 17)
    private BigDecimal holdProfitRate; // 持有收益率

}