package com.example.backend7team.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding
@ConfigurationProperties("jwt")
public class JwtProperties {

    private final String secret;
    private final String header;
    private final String prefix;
    private final Integer accessExp;
    private final Integer refreshExp;

    public JwtProperties(String secret, String header, String prefix
            , Integer accessExp, Integer refreshExp) {
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
        this.header = header;
        this.prefix = prefix;
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
    }
}
