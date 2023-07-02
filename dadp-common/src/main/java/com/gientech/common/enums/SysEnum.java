package com.gientech.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class SysEnum {

    @Getter
    @AllArgsConstructor
    public enum funcType {
        funcType_1("1", "菜单"),
        funcType_2("2", "按钮");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum importanceLevel {
        importanceLevel_0("0", "重要"),
        importanceLevel_1("1", "紧急"),
        importanceLevel_2("2", "普通");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum scheduleType {
        FEEDBACK("营销活动反馈跟进", "营销活动反馈跟进"),
        PHONE("电访跟进", "电访跟进"),
        FACE("面访跟进", "面访跟进"),
        DAILY("日常日程", "日常日程");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum scheduleSts {
        NORMAL("0", "正常"),
        OVERDUE("1", "过期");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum fileIsVaild {
        No("0", "不可用"),
        Yes("1", "可用");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum repaymentMethod {
        INTEREST("1", "等额本息还款"),
        PRINCIPAL("2", "等额本金还款"),
        PAYMONTHLY("3", "按月付息到期还本");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum chargeType {
        PERCENTAGE("0", "百分比"),
        FIXED("1", "固定值");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum meeting {
        SAVE("1", "保存"),
        UPDATE("2", "更新"),
        DELETE("3", "删除");

        private final String value;
        private final String content;
    }

    @Getter
    @AllArgsConstructor
    public enum fileType {
        PICTURE("1", "mettingImage"),
        RECORDING("2", "mettingRadio");


        private final String value;
        private final String content;
    }


    @Getter
    @AllArgsConstructor
    public enum ddcType {
        DDC_TYPE_1("1", "完全脱敏"),
        DDC_TYPE_2("2", "部分脱敏");


        private final String value;
        private final String content;
    }
}
