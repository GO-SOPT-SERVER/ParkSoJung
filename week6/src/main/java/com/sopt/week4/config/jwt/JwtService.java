package com.sopt.week4.config.jwt;

import com.sopt.week4.exception.Error;
import com.sopt.week4.exception.model.UnauthorizedException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final RedisTemplate<String, String> redisTemplate;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @PostConstruct
    protected void init() {
        jwtSecret = Base64.getEncoder()
                .encodeToString(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    // Access Token 발급
    public String issuedAccessToken(String userId) {
        final long accessTokenExpiryTime = 120 * 60 * 1000L;
        return issuedToken("access_token", accessTokenExpiryTime, userId);
    }

    // Refresh Token 발급
    public String issuedRefreshToken(String userId) {
        final long refreshTokenExpiryTime = 120 * 60 * 7 * 1000L;
        String refreshToken = issuedToken("refresh_token", refreshTokenExpiryTime, userId);

        redisTemplate.opsForValue().set(String.valueOf(userId), refreshToken, Duration.ofMillis(refreshTokenExpiryTime));
        return refreshToken;
    }

    // JWT 토큰 발급
    public String issuedToken(String tokenName, long expiryTime, String userId) {
        final Date now = new Date();

        // 클레임 생성
        final Claims claims = Jwts.claims()
                .setSubject(tokenName)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expiryTime));

        // private claim 등록
        claims.put("userId", userId);

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {
        final byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // JWT 토큰 검증
    public boolean verifyToken(String token) {
        try {
            final Claims claims = getBody(token);
            return true;
        } catch (RuntimeException e) {
            if (e instanceof ExpiredJwtException) {
                throw new UnauthorizedException(Error.TOKEN_TIME_EXPIRED_EXCEPTION, Error.TOKEN_TIME_EXPIRED_EXCEPTION.getMessage());
            }
            return false;
        }
    }

    private Claims getBody(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // JWT 토큰 내용 확인
    public String getJwtContents(String token) {
        final Claims claims = getBody(token);
        return (String) claims.get("userId");
    }
}
