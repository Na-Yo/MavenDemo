package com.xuzw.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDateTimeformatter {
    // java 8 bug
    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime dt1 = LocalDateTime.parse("2007-12-03 ");
        System.out.println();

    }
}
