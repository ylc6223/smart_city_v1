package com.belong.smart.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component // 将当前实体类交给spring容器进行托管
//@ConfigurationProperties(prefix = "belong.jwt")
public class JwtUtils {
    // 密钥
    public static String SECRET_KEY = "belong_token";

    // token 过期时间 24小时
    public static int ExpiresIn = 1000 * 60 * 60 * 24;

    // 生成token
    public static String createToken(String username) {
        String token = "";

        // 传入用户信息和密钥来生成token
        token = JWT.create()
                .withAudience(username) // 传入用户信息
                .withExpiresAt(new Date(System.currentTimeMillis() + ExpiresIn))  // token过期时间
                .sign(Algorithm.HMAC256(SECRET_KEY));  // 传入密钥生成token

        return token;
    }

    // 校验token
    public static Boolean verifyToken(String token) {
        try {
            // 根据密钥来校验token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
            jwtVerifier.verify(token);
            return true;

        } catch (JWTVerificationException e) {
            throw new RuntimeException("token校验失败");
        }
    }
}
