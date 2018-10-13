package com.xuzw.test;

import com.xuzw.util.HttpUtil;

import java.util.HashMap;

public class TestHttp {
    public static void main(String[] args) {
        String url="https://www.jhmeeting.com";
        String jwt="";
        url+="";

        String post = HttpUtil.post("https://www.jhmeeting.com/", new HashMap<String,Object>());

        System.out.println(post);
    }
}

