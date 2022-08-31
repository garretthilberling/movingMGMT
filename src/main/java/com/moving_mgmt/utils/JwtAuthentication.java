package com.moving_mgmt.utils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import io.jsonwebtoken.*;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

public class JwtAuthentication {
    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createJWT(String subject) {
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
