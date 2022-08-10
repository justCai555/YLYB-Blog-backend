package com.ylyb.blog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class TokenUtil {
    //过期时间
    private static final long EXPIRE_DATE=30*60*100000;
    // token秘钥
    private static final String TOKEN_SECRET = "DNWKA-YLYB0205_DHJWA-MDL0914";

    /**
     *
     * @param uid
     * @return token
     */
    public static String generateToken(String uid){
        try{
            Algorithm aLgorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            String token = JWT.create().withKeyId(uid).withExpiresAt(date).sign(aLgorithm);
            return token;

        }catch (JWTCreationException e){
            System.out.println(e+"   create token failed!!!");

        }
        return null;
    }

    /**
     *
     * @param token
     * @return boolean类型，验证的结果
     */
    public static boolean verify(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
