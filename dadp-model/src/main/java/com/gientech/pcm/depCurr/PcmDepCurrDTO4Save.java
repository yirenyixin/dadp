package com.gientech.pcm.depCurr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "活期存款--更新DTO")
public class PcmDepCurrDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户ID", required = true, position = 1)
    @NotBlank(message = "[custId] 客户ID不能为空")
    @Size(max = 32, message = "客户ID的长度必须小于等于32")
    private String custId; // 客户ID

    @ApiModelProperty(value = "ID", required = true, position = 2)
//    @NotBlank(message = "[depCurrId] ID不能为空")
    @Size(max = 32, message = "ID的长度必须小于等于32")
    private String depCurrId; // ID

    @ApiModelProperty(value = "ECIF客户ID", required = true, position = 3)
    //@NotBlank(message = "[ecifCustId] ECIF客户ID不能为空")
    @Size(max = 32, message = "ECIF客户ID的长度必须小于等于32")
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "客户名称", required = true, position = 4)
    //@NotBlank(message = "[custName] 客户名称不能为空")
    @Size(max = 128, message = "客户名称的长度必须小于等于128")
    private String custName; // 客户名称

    @ApiModelProperty(value = "法人机构号", required = true, position = 5)
    //@NotBlank(message = "[lawOrgId] 法人机构号不能为空")
    @Size(max = 32, message = "法人机构号的长度必须小于等于32")
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "产品代码", required = true, position = 6)
   // @NotBlank(message = "[prodCode] 产品代码不能为空")
    @Size(max = 32, message = "产品代码的长度必须小于等于32")
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "产品名称", required = true, position = 7)
    //@NotBlank(message = "[prodName] 产品名称不能为空")
    @Size(max = 100, message = "产品名称的长度必须小于等于100")
    private String prodName; // 产品名称

    @ApiModelProperty(value = "账号/卡号", required = true, position = 8)
    //@NotBlank(message = "[acctNo] 账号/卡号不能为空")
    @Size(max = 32, message = "账号/卡号的长度必须小于等于32")
    private String acctNo; // 账号/卡号

    @ApiModelProperty(value = "币种", required = true, position = 9)
    //@NotBlank(message = "[currNo] 币种不能为空")
    @Size(max = 32, message = "币种的长度必须小于等于32")
    private String currNo; // 币种

    @ApiModelProperty(value = "上日余额", position = 10)
    @DecimalMin(value = "0", message = "[bal] 上日余额不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[bal] 上日余额不能大于99999999999999999999.99")
    private Double bal; // 上日余额

    @ApiModelProperty(value = "账户状态", required = true, position = 11)
    //@NotBlank(message = "[acctSts] 账户状态不能为空")
    @Size(max = 32, message = "账户状态的长度必须小于等于32")
    private String acctSts; // 账户状态

    @ApiModelProperty(value = "子账户开户行", required = true, position = 12)
    //@NotBlank(message = "[openOrgNo] 子账户开户行不能为空")
    @Size(max = 32, message = "子账户开户行的长度必须小于等于32")
    private String openOrgNo; // 子账户开户行

    @ApiModelProperty(value = "开户日期", required = true, position = 13)
    //@NotBlank(message = "[startDt] 开户日期不能为空")
    @Size(max = 8, message = "开户日期的长度必须小于等于8")
    private String startDt; // 开户日期

    @ApiModelProperty(value = "凭证号", required = true, position = 14)
    //@NotBlank(message = "[voucherNo] 凭证号不能为空")
    @Size(max = 32, message = "凭证号的长度必须小于等于32")
    private String voucherNo; // 凭证号

    @ApiModelProperty(value = "活期子账户", required = true, position = 15)
    //@NotBlank(message = "[subAcctNo] 活期子账户不能为空")
    @Size(max = 32, message = "活期子账户的长度必须小于等于32")
    private String subAcctNo; // 活期子账户

    @ApiModelProperty(value = "当前余额", position = 16)
    @DecimalMin(value = "0", message = "[currentBal] 当前余额不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[currentBal] 当前余额不能大于99999999999999999999.99")
    private Double currentBal; // 当前余额

    // Getters and setters
}