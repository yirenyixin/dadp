package com.gientech.pcm.cust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 【客户】PcmCust修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "客户--修改DTO")
public class PcmCustDTO4Update implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户ID", required = true, position = 1)
    @NotBlank(message = "[custID]客户ID，不能为空")
    @Size(max = 32, message = "客户ID的长度必须小于等于32")
    private String custId;

    @ApiModelProperty(value = "ECIF客户ID", required = true, position = 2)
//    @NotBlank(message = "[ecifCustId]ECIF客户ID，不能为空")
    @Size(max = 32, message = "ECIF客户ID的长度必须小于等于32")
    private String ecifCustId;

    @ApiModelProperty(value = "客户名称", required = true, position = 3)
//    @NotBlank(message = "[custName]客户名称，不能为空")
    @Size(max = 128, message = "客户名称的长度必须小于等于128")
    private String custName;

    @ApiModelProperty(value = "法人机构号", required = true, position = 4)
//    @NotBlank(message = "[lawOrgId]法人机构号，不能为空")
    @Size(max = 32, message = "法人机构号的长度必须小于等于32")
    private String lawOrgId;

    @ApiModelProperty(value = "法人机构名称", position = 5)
    @Size(max = 128, message = "法人机构名称的长度必须小于等于128")
    private String lawOrgName;

    @ApiModelProperty(value = "客户状态", position = 6)
    @Size(max = 32, message = "客户状态的长度必须小于等于32")
    private String custState;

    @ApiModelProperty(value = "证件类型", required = true, position = 7)
//    @NotBlank(message = "[certType]证件类型，不能为空")
    @Size(max = 32, message = "证件类型的长度必须小于等于32")
    private String certType;

    @ApiModelProperty(value = "证件号码", required = true, position = 8)
//    @NotBlank(message = "[certNo]证件号码，不能为空")
    @Size(max = 20, message = "证件号码的长度必须小于等于20")
    private String certNo;

    @ApiModelProperty(value = "证件号码归属地", required = true, position = 9)
//    @NotBlank(message = "[certAddr]证件号码归属地，不能为空")
    @Size(max = 150, message = "证件号码归属地的长度必须小于等于150")
    private String certAddr;

    @ApiModelProperty(value = "手机号", position = 10)
    @Size(max = 32, message = "手机号的长度必须小于等于32")
    private String mobile;

    @ApiModelProperty(value = "联系电话", position = 11)
    @Size(max = 32, message = "联系电话的长度必须小于等于32")
    private String tel;

    @ApiModelProperty(value = "联系地址", position = 12)
    @Size(max = 512, message = "联系地址的长度必须小于等于512")
    private String address;

    @ApiModelProperty(value = "性别", position = 13)
    @Size(max = 32, message = "性别的长度必须小于等于32")
    private String sex;

    @ApiModelProperty(value = "婚姻状态", position = 14)
    @Size(max = 32, message = "性别的长度必须小于等于32")
    private String marStat;

    @ApiModelProperty(value = "出生日期", position = 15)
    @Size(max = 8, message = "出生日期的长度必须小于等于8")
    private String birthday;

    @ApiModelProperty(value = "名族", position = 16)
    @Size(max = 32, message = "名族的长度必须小于等于32")
    private String nation;

    @ApiModelProperty(value = "国籍", position = 17)
    @Size(max = 32, message = "国籍的长度必须小于等于32")
    private String country;

    @ApiModelProperty(value = "居住性质", position = 18)
    @Size(max = 32, message = "居住性质的长度必须小于等于32")
    private String livingType;

    @ApiModelProperty(value = "家庭是否拥有车辆", position = 19)
    @Size(max = 32, message = "家庭是否拥有车辆的长度必须小于等于32")
    private String isOwnCar;

    @ApiModelProperty(value = "家庭是否拥有房地厂", position = 20)
    @Size(max = 32, message = "家庭是否拥有房地厂的长度必须小于等于32")
    private String isOwnHouse;

    @ApiModelProperty(value = "家庭年收入", position = 21)
    @Size(max = 20, message = "家庭年收入的长度必须小于等于20")
    private String homeIntTotal;

    @ApiModelProperty(value = "最高学历", position = 22)
    @Size(max = 32, message = "最高学历的长度必须小于等于32")
    private String highestEdu;

    @ApiModelProperty(value = "爱好", position = 23)
    @Size(max = 32, message = "爱好的长度必须小于等于32")
    private String hobby;

    @ApiModelProperty(value = "行业", position = 24)
    @Size(max = 32, message = "行业的长度必须小于等于32")
    private String trade;

    @ApiModelProperty(value = "职业", position = 25)
    @Size(max = 32, message = "职业的长度必须小于等于32")
    private String profession;

    @ApiModelProperty(value = "职务", position = 26)
    @Size(max = 32, message = "职务的长度必须小于等于32")
    private String position;

    @ApiModelProperty(value = "工作单位", position = 27)
    @Size(max = 128, message = "工作单位的长度必须小于等于128")
    private String unitNm;

    @ApiModelProperty(value = "黑名单客户", position = 28)
    @Size(max = 32, message = "黑名单客户的长度必须小于等于32")
    private String isBlacklist;

    @ApiModelProperty(value = "黑名单来源", position = 29)
    @Size(max = 32, message = "黑名单来源的长度必须小于等于32")
    private String blacklistSource;

    @ApiModelProperty(value = "备注", position = 30)
    @Size(max = 200, message = "备注的长度必须小于等于200")
    private String remark;

    @ApiModelProperty(value = "备注人", position = 31)
    @Size(max = 32, message = "备注人的长度必须小于等于32")
    private String remarkUser;

    @ApiModelProperty(value = "年龄", required = true, position = 32)
//    @Min(value = 0, message = "[sortNo]排序号不能小于0")
//    @Max(value = 9999999, message = "[sortNo]排序号不能大于{value}")
    private Integer age;

    @ApiModelProperty(value = "年龄范围", position = 33)
    @Size(max = 8, message = "年龄范围的长度必须小于等于8")
    private String ageArea;

    @ApiModelProperty(value = "地区编号", position = 34)
    @Size(max = 16, message = "地区编号的长度必须小于等于16")
    private String areaNo;

    @ApiModelProperty(value = "是否商户", position = 35)
    @Size(max = 32, message = "是否商户的长度必须小于等于32")
    private String isMerchant;

    @ApiModelProperty(value = "是否股东", position = 36)
    @Size(max = 32, message = "是否股东的长度必须小于等于32")
    private String isStock;

    @ApiModelProperty(value = "单位地址", position = 37)
    @Size(max = 512, message = "单位地址的长度必须小于等于512")
    private String unitAddr;

    @ApiModelProperty(value = "单位电话", position = 38)
    @Size(max = 32, message = "单位电话的长度必须小于等于32")
    private String unitTel;

    @ApiModelProperty(value = "是否本行员工", position = 39)
    @Size(max = 32, message = "是否本行员工的长度必须小于等于32")
    private String isEmployee;
}
