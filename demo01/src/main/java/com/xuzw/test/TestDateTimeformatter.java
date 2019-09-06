package com.xuzw.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestDateTimeformatter {
    // java 8 bug
    public static void main(String[] args) {

        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dt1 = LocalDateTime.parse("2007-12-03 ");
        System.out.println();*/
        /*Date secondEndTime = e.getSecondEndTime();
        Instant instant = secondEndTime.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        String format = localDateTime.format(dateTimeFormatter);*/
        test1();

    }

    static void test1(){
        StringBuilder fileName = new StringBuilder();
        fileName.append("供应商01");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime now = LocalDateTime.now();
        String nowFormat = now.format(dateTimeFormatter);
        fileName.append("报价文件压缩包").append("(").append(nowFormat).append(")");
        System.out.println(fileName.toString());
    }
}
