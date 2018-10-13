package com.xuzw.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;

public class JHJwtUtil
{
	private static final String appId = "41235379"; // 用户在简会的appId
	private static final String appSecret = "hKSltAa6joDdp24I";	// 用户在简会的appSecret

	public static String cerateJwt(){
		try {
			Calendar cal = Calendar.getInstance(); // 创建日历
			cal.setTime(new Date()); // 设置时间
			cal.add(Calendar.HOUR_OF_DAY, 1); // 增加1小时
			Date expiresAt = cal.getTime();

			Algorithm algorithm = Algorithm.HMAC256(appSecret);
			String token = JWT.create()
					.withIssuer(appId)
					.withExpiresAt(expiresAt) // 超时时间
					.withClaim("room", "10207") // 会议室名字
//					.withClaim("num", 4) // 限制会议室最高人数
//					.withClaim("notify_url", "") // 通知回调地址
					.sign(algorithm);
			System.out.println(token);
			return token;
		} catch (UnsupportedEncodingException exception){
			System.out.println(exception);
		} catch (JWTCreationException exception){
			System.out.println(exception);
		}
		return null;
	}

    public static JWT decodeToken(String token)
    {
    	try {
			JWT decode = JWT.decode(token);
			System.out.println(decode.getClaims());
			System.out.println(decode.getSignature());
			System.out.println(decode.getIssuer());
			System.out.println(decode.getExpiresAt());
			System.out.println(decode.getClaim("room").asString());
			System.out.println(decode.getClaim("room_id").asInt());
			return decode;
		}catch (Exception e){
			System.out.println("解密失败！");
			return null;
		}
    }
}
