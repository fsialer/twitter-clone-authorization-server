package com.fernando.ms.auth.app.application.ports.output;

import com.fernando.ms.auth.app.domain.model.Auth;

public interface ExternalUserOutputPort {
    Auth authentication(Auth auth);
}
