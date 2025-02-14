package com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.client.impl;

import com.fernando.ms.auth.app.domain.model.Auth;
import com.fernando.ms.auth.app.domain.model.User;
import com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.client.UserClient;
import com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.models.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserClientImpl implements UserClient {
    @Value("${users-service.url}/auth")
    private String userServiceUrl;


    @Override
    public AuthResponse auth(Auth auth) {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.postForObject(userServiceUrl,
                auth,
                AuthResponse.class);
    }
}
