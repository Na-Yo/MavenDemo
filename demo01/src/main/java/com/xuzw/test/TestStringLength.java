package com.xuzw.test;

public class TestStringLength {

    public static void main(String[] args) {

        String desc="中文字符长度";

        System.out.println(desc.length());

        byte[] bytes = desc.getBytes();

        System.out.println(bytes.length);

    }
}
