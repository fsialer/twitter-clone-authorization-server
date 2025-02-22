package com.fernando.ms.auth.app.infrastructure.config;

import com.fernando.ms.auth.app.domain.model.CustomUserDetail;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomTokenEnhancer implements OAuth2TokenCustomizer<JwtEncodingContext> {
    @Override
    public void customize(JwtEncodingContext context) {

        if (context.getTokenType().getValue().equals("access_token")) {
            var authentication = context.getPrincipal();
            if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetail userDetails) {
                context.getClaims().claims((claims) -> claims.put("user_id", userDetails.getId()));
            }
        }
    }
}
