package com.example.springboottest.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenUtils {
    public static final long EXPIRE_TIME=15*60*1000;

    private static final String TOKEN_SECRET = "mflexisveryhardmode";

    public static boolean verify(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            DecodedJWT decode = JWT.decode(token);
           // System.out.println("decode"+jwt.getSubject());

            return true;
        }catch(Exception e){
            return false;
        }
    }
}
