package com.whaleal.jmcwebhook.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * JWT工具
 *
 * @desc 生成jwt密钥
 * @author: jy
 * @Date: 2021/09/29
 */
public class JwtHelper {

    /**
     * 24小时有效期
     */
    private static final long TOKEN_EXPIRATION = 24 * 60 * 60 * 1000;
    /**
     * 密钥
     */
    private static final String TOKEN_SIGN_KEY = "webhook";

    /**
     * api_key
     */
    private static final String api_keys = "3c24162c,e7b63327,8c34ce78,543b010c,593a69f7";

    private static final List<String> apiKeyList = Arrays.asList(api_keys.split(","));

    /**
     * 创建密钥
     *
     * @param hostId hostId
     * @return token
     */
    public static String createAgentToken(Object hostId) {
        String token = Jwts.builder()
                .setSubject("OPS-Agent")
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                .claim("hostId", hostId)
                .signWith(SignatureAlgorithm.HS256, TOKEN_SIGN_KEY)
                .compact();
        return token;
    }


    /**
     * 根据token字符串得到hostId
     *
     * @param token token字符串信息
     * @return ""
     */
    public static Boolean authToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();

        String api_key = claims.get("api_key", String.class);

        return apiKeyList.contains(api_key);
    }

}
