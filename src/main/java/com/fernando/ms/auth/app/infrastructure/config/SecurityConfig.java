package com.fernando.ms.auth.app.infrastructure.config;

import com.fernando.ms.auth.app.application.services.AuthorizationProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthorizationProviderService authorizationProviderService;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(List.of(authorizationProviderService));
    }
}
