package com.xuzw.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {

    public static void main(String[] args) {
        String s="/ebidding/taurus/Portlet/intoIndex.htm";

        String rules="^//ebidding//(.*)/.*$";

        Pattern pattern = Pattern.compile(rules);
        Matcher matcher = pattern.matcher(s);

        String group = matcher.group();
        System.out.println(group);

    }
}
