package com.moore.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.moore.constant.Constant;
import com.moore.model.entity.UserEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    /**
     * @param userEntity
     * @return
     */
    public static String createToken(UserEntity userEntity) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + Constant.EXPIRE_TIME);
            // 设置头部信息
            Map<String, Object> header = new HashMap<String, Object>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userEntity.getId())
                    .withClaim("userName", userEntity.getUserName())
                    .withExpiresAt(date)
                    .sign(Algorithm.HMAC256(Constant.SECRET));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> validToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constant.SECRET)).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaims();
        } catch (Exception e) {
            return new HashMap<String, Claim>();
        }
    }
}