package com.pofo.pofoapp.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * packageName    : com.pofo.pofoapp.common.jwt
 * fileName       : JwtTokenProvider
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@Component
public class JwtTokenProvider {
    @Value("${app.jwt.secret}")
    private String secret;
    @Value("${app.jwt.expire}")
    private int expire;

    public String generateToken(Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expire);

        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }
}
