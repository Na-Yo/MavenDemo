package com.xuzw.test;

import java.math.BigDecimal;

public class TestBigDecimal {

    public static void main(String[] args) {

       /* BigDecimal bigDecimal1 = new BigDecimal("");
        System.out.println(bigDecimal1);*/

        BigDecimal bigDecimal = new BigDecimal("100000000000000000000000.000000000000").setScale(9, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.stripTrailingZeros());
        System.out.println(new BigDecimal(bigDecimal.stripTrailingZeros().toPlainString()));
    }
}
