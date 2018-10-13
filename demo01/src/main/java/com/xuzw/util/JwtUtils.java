package com.xuzw.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

public class JwtUtils {

    private static final String base64Security="hKSltAa6joDdp24I";

    public static String createJWT(int hours)
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

      /*  {
            "exp": 1526366319,
                "iss": "41235379",
                "room": "10207"
        }*/

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .claim("exp", 1526366319)
                .claim("iss", "41235379")
                .claim("room", "10207")
//                .setIssuer(issuer)
//                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey);

        //添加Token过期时间
        if (hours >= 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY)+hours);

            Date exp = new Date(calendar.getTimeInMillis());
            builder.setExpiration(exp);//过期时间
                   // .setNotBefore(now);
        }
        //生成JWT
        return builder.compact();
    }

    public static Claims parseJWT(String jsonWebToken){
        try
        {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
}
