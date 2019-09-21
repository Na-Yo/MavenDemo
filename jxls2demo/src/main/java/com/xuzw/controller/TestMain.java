package com.xuzw.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xuzw.util.Jxls2Util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws Exception {
        // 模板路径和输出流
        long l = System.currentTimeMillis();
        String templatePath = "E://SpringCloud//MavenDemo//jxls2demo//src//main//resources//template//template.xlsx";
        OutputStream os = new FileOutputStream("E://SpringCloud//MavenDemo//jxls2demo//src//main//resources//template//data.xlsx");
        // 定义一个Map，往里面放入要在模板中显示数据
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", "001");
        model.put("name", "张三");
        model.put("age", "十八");
        model.put("age1", "十八");
        model.put("age2", "十八");
        model.put("age3", "十八");
        model.put("age4", "十八");
        model.put("age5", "十八");
        model.put("age6", "十八");

        ArrayList<Object> objects = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            objects.add(model);
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("data",objects);
        //调用之前写的工具类，传入模板路径，输出流，和装有数据Map
        Jxls2Util.exportExcel(templatePath, os, dataMap);
        os.close();
        System.out.println("完成");
        System.out.println("耗时："+(System.currentTimeMillis()-l));
    }
}
