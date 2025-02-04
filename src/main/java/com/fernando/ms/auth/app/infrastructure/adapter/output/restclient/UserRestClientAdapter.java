package com.fernando.ms.auth.app.infrastructure.adapter.output.restclient;

import com.fernando.ms.auth.app.application.ports.output.ExternalUserOutputPort;
import com.fernando.ms.auth.app.domain.model.Auth;
import com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.client.UserClient;
import com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.mapper.UserRestClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRestClientAdapter implements ExternalUserOutputPort {
    private final UserClient userClient;
    private final UserRestClientMapper userRestClientMapper;

    @Override
    public Auth authentication(Auth auth) {
        return userRestClientMapper.toAuth(userClient.auth(auth));
    }
}
