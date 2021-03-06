package com.aeye.thirdeye.config.Auth;

import com.aeye.thirdeye.repository.UserRepository;
import com.aeye.thirdeye.token.AuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OauthJwtConfig {

    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public AuthTokenProvider jwtProvider() {
        return new AuthTokenProvider(secret, userRepository);

    }
}
