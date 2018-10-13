package com.xuzw.test;

import com.xuzw.util.JwtUtils;
import io.jsonwebtoken.Claims;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJwt {

    public static void main(String[] args) {

       // String jwtSercert= JwtUtils.creatJwt(); {exp=1526370852, iss=41235379, room=10207, nbf=1526367251} 1970-01-18 11-59-27
        String s = JwtUtils.createJWT(1);
        System.out.println(s);

        Claims claims = JwtUtils.parseJWT(s);

         System.out.println(claims.toString());

        Date date = new Date((Integer) claims.get("nbf"));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        System.out.println(sdf.format(date));

        String jwt="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjYzNjYzMTksImlzcyI6IjQxMjM1Mzc5Iiwicm9vbSI6IjEwMjA3In0.ZoFxstcTxNdDIXhfmXd5Ii2xzTKp2aUUirW6X6ih22M";
//        String jwt="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjYzNzE1ODcsImlzcyI6IjQxMjM1Mzc5Iiwicm9vbSI6IjEwMjA3IiwibmJmIjoxNTI2MzY3OTg2fQ.yVsemzTp1XIqAlE3KUrKhdbdHdAPhAVTc99as5wy6us";
        Claims claims1 = JwtUtils.parseJWT(jwt);

        System.out.println("简会官方的密文解密====="+claims1.toString());
    }
}
