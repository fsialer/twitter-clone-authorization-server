package com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.client;

import com.fernando.ms.auth.app.domain.model.Auth;
import com.fernando.ms.auth.app.domain.model.User;
import com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.models.response.AuthResponse;

public interface UserClient {
    AuthResponse auth(Auth auth);
}
