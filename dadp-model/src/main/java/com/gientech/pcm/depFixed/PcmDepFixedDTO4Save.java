package com.gientech.pcm.depFixed;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "PCM_DEP_FIXED - PcmDepFixedDTO4Save")
public class PcmDepFixedDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "DEP_FIXED_ID", required = true, position = 1)
    @NotBlank(message = "[depFixedId] DEP_FIXED_ID不能为空")
    @Size(max = 32, message = "DEP_FIXED_ID的长度必须小于等于32")
    private String depFixedId; // ID

    @ApiModelProperty(value = "CUST_ID", position = 2)
    @NotBlank(message = "[custId] CUST_ID不能为空")
    @Size(max = 32, message = "CUST_ID的长度必须小于等于32")
    private String custId; // 客户ID

    @ApiModelProperty(value = "ECIF_CUST_ID", position = 3)
    @NotBlank(message = "[ecifCustId] ECIF_CUST_ID不能为空")
    @Size(max = 32, message = "ECIF_CUST_ID的长度必须小于等于32")
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "CUST_NAME", position = 4)
    @NotBlank(message = "[custName] 客户名称不能为空")
    @Size(max = 128, message = "客户名称的长度必须小于等于128")
    private String custName; // 客户名称

    @ApiModelProperty(value = "LAW_ORG_ID", position = 5)
    @NotBlank(message = "[lawOrgId] 法人机构号不能为空")
    @Size(max = 32, message = "法人机构号的长度必须小于等于32")
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "PROD_CODE", position = 6)
    @NotBlank(message = "[prodCode] 产品代码不能为空")
    @Size(max = 32, message = "产品代码的长度必须小于等于32")
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "PROD_NAME", position = 7)
    @NotBlank(message = "[prodName] 产品名称不能为空")
    @Size(max = 100, message = "产品名称的长度必须小于等于100")
    private String prodName; // 产品名称

    @ApiModelProperty(value = "ACCT_NO", position = 8)
    @NotBlank(message = "[acctNo] 账号不能为空")
    @Size(max = 32, message = "账号的长度必须小于等于32")
    private String acctNo; // 账号

    @ApiModelProperty(value = "SUB_ACCT_NO", position = 9)
    @NotBlank(message = "[subAcctNo] 子账号不能为空")
    @Size(max = 32, message = "子账号的长度必须小于等于32")
    private String subAcctNo; // 子账号

    @ApiModelProperty(value = "ACCT_TYPE", position = 10)
    @NotBlank(message = "[acctType] 存款类型不能为空")
    @Size(max = 32, message = "存款类型的长度必须小于等于32")
    private String acctType; // 存款类型

    @ApiModelProperty(value = "FLOAT_RATE", position = 11)
    @DecimalMin(value = "0", message = "[floatRate] 浮动比率不能小于0")
    @DecimalMax(value = "999999.999999", message = "[floatRate] 浮动比率不能大于999999.999999")
    private Float floatRate; // 浮动比率

    @ApiModelProperty(value = "RATE", position = 12)
    @DecimalMin(value = "0", message = "[rate] 协议利率不能小于0")
    @DecimalMax(value = "999999.999999", message = "[rate] 协议利率不能大于999999.999999")
    private Float rate; // 协议利率

    @ApiModelProperty(value = "CURR_NO", position = 13)
    @NotBlank(message = "[currNo] 币种不能为空")
    @Size(max = 32, message = "币种的长度必须小于等于32")
    private String currNo; // 币种

    @ApiModelProperty(value = "BAL", position = 14)
    @DecimalMin(value = "0", message = "[bal] 上日余额不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[bal] 上日余额不能大于99999999999999999999.99")
    private Float bal; // 上日余额

    @ApiModelProperty(value = "TERM", position = 15)
    @NotBlank(message = "[term] 存期不能为空")
    @Size(max = 8, message = "存期的长度必须小于等于8")
    private String term; // 存期

    @ApiModelProperty(value = "END_DATE", position = 16)
    @NotBlank(message = "[endDate] 到期日期不能为空")
    @Size(max = 8, message = "到期日期的长度必须小于等于8")
    private String endDate; // 到期日期

    @ApiModelProperty(value = "ACCT_STS", position = 17)
    @NotBlank(message = "[acctSts] 账户状态不能为空")
    @Size(max = 8, message = "账户状态的长度必须小于等于8")
    private String acctSts; // 账户状态

    @ApiModelProperty(value = "OPEN_ORG_NO", position = 18)
    @NotBlank(message = "[openOrgNo] 开户机构号不能为空")
    @Size(max = 32, message = "开户机构号的长度必须小于等于32")
    private String openOrgNo; // 开户机构号

    @ApiModelProperty(value = "START_DT", position = 19)
    @NotBlank(message = "[startDt] 起存日期不能为空")
    @Size(max = 8, message = "起存日期的长度必须小于等于8")
    private String startDt; // 起存日期

    @ApiModelProperty(value = "VOUCHER_NO", position = 20)
    @NotBlank(message = "[voucherNo] 凭证号不能为空")
    @Size(max = 32, message = "凭证号的长度必须小于等于32")
    private String voucherNo; // 凭证号


    // Getters and setters
}