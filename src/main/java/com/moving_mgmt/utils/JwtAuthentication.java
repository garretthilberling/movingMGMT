package com.moving_mgmt.utils;

import java.security.Key;
import java.security.Provider;
import java.security.Security;
import java.util.Base64;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

import javax.crypto.spec.SecretKeySpec;

public class JwtAuthentication {
    private static Dotenv dotenv = Dotenv.load();
    private static String secret = dotenv.get("SECRET");
    private static byte[] decodeKey = Base64.getDecoder().decode(secret);
    private static Key key = new SecretKeySpec(decodeKey,0,decodeKey.length, "HMACSHA256");

    public static String createJWT(String subject) {
        System.out.println("KEY: " + Base64.getEncoder().encodeToString(key.getEncoded()));
        return Jwts.builder().setSubject(subject).signWith(key).compact();
    }

    public static Jws<Claims> decodeJWT(String jwt) {
        Jws<Claims> jws;
        jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt);
        return jws;
    }
}
