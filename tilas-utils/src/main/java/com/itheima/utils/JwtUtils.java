package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
@Component
public class JwtUtils {

    // ⚠️ 请把这里的秘钥换成你测试类里的一模一样的秘钥！长度必须大于等于32个字符！
    private static final String SECRET_KEY = "itheimaSecretKey1234567890itheima";

    // 12小时的过期时间（单位：毫秒）
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 1. 生成 JWT 令牌
     * @param claims 自定义数据（如 id, username），不要放密码
     * @return 生成的 JWT 字符串
     */
    public static String generateJwt(Map<String, Object> claims) {
        // 构建密钥对象
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .claims(claims)                                                // 设置Payload
                .expiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) // 设置12小时过期
                .signWith(key)                                                 // 使用密钥签名
                .compact();                                                    // 生成最终字符串
    }

    /**
     * 2. 解析 JWT 令牌
     * @param jwt 前端传回来的令牌字符串
     * @return 解析出来的 Claims（本质是一个 Map）
     */
    public static Claims parseJwt(String jwt) {
        // 必须使用和生成时一模一样的密钥
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.parser()
                .verifyWith(key)                // 验签
                .build()                        // 构建解析器
                .parseSignedClaims(jwt)         // 解析
                .getPayload();                  // 获取内容
    }
}