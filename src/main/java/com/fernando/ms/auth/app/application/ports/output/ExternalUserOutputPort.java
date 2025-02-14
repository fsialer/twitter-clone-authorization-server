package com.fernando.ms.auth.app.application.ports.output;

import com.fernando.ms.auth.app.domain.model.Auth;
import com.fernando.ms.auth.app.domain.model.User;

public interface ExternalUserOutputPort {
    User authentication(Auth auth);
}
