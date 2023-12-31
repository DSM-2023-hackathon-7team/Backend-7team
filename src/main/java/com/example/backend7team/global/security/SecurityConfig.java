package com.example.backend7team.global.security;

import com.example.backend7team.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .cors().and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()

                // users
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signin").permitAll()

                // accidents
                .antMatchers(HttpMethod.GET, "/accidents").permitAll()
                .antMatchers(HttpMethod.GET, "/accidents/{accident-id}").permitAll()
                .antMatchers(HttpMethod.GET, "/accidents/information").permitAll()
                .antMatchers(HttpMethod.GET, "/accidents/information/{accident-information-id}").permitAll()

                // comments
                .antMatchers(HttpMethod.GET, "/comments/accident-information/{accident-information-id}").permitAll()
                .antMatchers(HttpMethod.GET, "/comments/accident/{accident-id}").permitAll()

                // files
                .antMatchers(HttpMethod.POST, "/files").permitAll()

                .anyRequest().authenticated()
                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
