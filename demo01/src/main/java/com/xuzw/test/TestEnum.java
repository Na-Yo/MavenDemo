package com.xuzw.test;

import com.xuzw.demo.util.MaterialHandleExecutePlanExcelEnum;

public class TestEnum {

    /**
     * 枚举类测试
     * @param args
     */
    public static void main(String[] args) {
        MaterialHandleExecutePlanExcelEnum[] values = MaterialHandleExecutePlanExcelEnum.values();
        for (MaterialHandleExecutePlanExcelEnum materialHandleExecutePlanExcelEnum : values) {
            String desc = materialHandleExecutePlanExcelEnum.toString();
            System.out.println("desc===="+desc);
            System.out.println("ordinal===="+materialHandleExecutePlanExcelEnum.ordinal());
            System.out.println("name===="+materialHandleExecutePlanExcelEnum.name());
        }
    }

}
