package com.xuzw.util;

public enum MaterialHandleExecutePlanExcelEnum {
    PLAN_MARK("计划标识"),
    HANDLE_COMPANY_NAME("处置企业*"),
    EQUIPMENT_CODE("设备编码*"),
    TYPE("处置类别*"),
    CODE("物料编码"),
    NAME("物料名称*"),
    DESC("物料描述"),
    UNIT("计量单位*"),
    NUM("处置数量*"),
    BUY_TIME("购置日期"),
    ORIGINAL_VALUE("原值*"),
    NET_VALUE("净值"),
    PROJECTED_REVENUE("预计收益"),
    ESTIMATED_NET_VALUE("预计净收益"),
    ASSESSED_VALUE("评估值"),
    REMARK("备注"),
    USER_NAME("拍卖员*");

    public final String DescInfo;

    private MaterialHandleExecutePlanExcelEnum(String DescInfo){
        this.DescInfo=DescInfo;
    }

    public String toString(){
        return String.valueOf(this.DescInfo);
    }

}
