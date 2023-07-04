package com.example.backend7team.global.security.jwt;

import com.example.backend7team.domain.user.domain.RefreshToken;
import com.example.backend7team.domain.user.domain.repository.RefreshTokenRepository;
import com.example.backend7team.global.exception.ExpiredTokenException;
import com.example.backend7team.global.exception.InvalidTokenException;
import com.example.backend7team.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthDetailsService authDetailsService;
    private final JwtProperties jwtProperties;

    public String generateAccessToken(String accountId) {
        return generateToken(accountId, TokenType.ACCESS, jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String accountId) {
        String token = generateToken(accountId, TokenType.REFRESH, jwtProperties.getRefreshExp());
        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(accountId)
                .token(token)
                .ttl(jwtProperties.getRefreshExp().longValue())
                .build()
        );
        return token;
    }

    private String generateToken(String accountId, TokenType tokenType, Integer exp) {
        return Jwts.builder()
                .setSubject(accountId)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (exp * 1000)))
                .claim("type", tokenType.name())
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        if (!claims.get("type").equals(TokenType.ACCESS.name())) {
            throw InvalidTokenException.EXCEPTION;
        }

        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "");
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader(jwtProperties.getHeader());
        if (token != null && token.startsWith(jwtProperties.getPrefix())) {
            token.replace(jwtProperties.getPrefix(), "");
        }
        return null;
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }
}
