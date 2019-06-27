package com.xuzw.test;

import com.xuzw.util.MaterialHandleExecutePlanExcelEnum;

public class TestEnum {

    /**
     * 枚举类测试
     * @param args
     */
    public static void main(String[] args) {
        MaterialHandleExecutePlanExcelEnum[] values = MaterialHandleExecutePlanExcelEnum.values();
        for (MaterialHandleExecutePlanExcelEnum materialHandleExecutePlanExcelEnum : values) {
            String desc = materialHandleExecutePlanExcelEnum.toString();
            System.out.println(desc);
        }
    }

}
