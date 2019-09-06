package com.xuzw.test;

import java.text.MessageFormat;

public class TestZhanWeiFu {
    public static void main(String[] args) {
        String s= MessageFormat.format("#{0}{1}","11","对对对");;
        System.out.println(s);
    }
}
