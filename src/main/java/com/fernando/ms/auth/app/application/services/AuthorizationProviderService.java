package com.fernando.ms.auth.app.application.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernando.ms.auth.app.application.ports.output.ExternalUserOutputPort;
import com.fernando.ms.auth.app.domain.model.Auth;
import com.fernando.ms.auth.app.domain.model.CustomUserDetail;
import com.fernando.ms.auth.app.domain.model.ErrorResponse;
import com.fernando.ms.auth.app.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
public class AuthorizationProviderService implements AuthenticationProvider{
    private final  ExternalUserOutputPort externalUserOutputPort;
    private final ObjectMapper objectMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try{
            String username = authentication.getName();
            String password = (String) authentication.getCredentials();
            User authResponse=externalUserOutputPort.authentication(Auth.builder().username(username).password(password).build());
            if (authResponse == null) {
                throw new BadCredentialsException("Invalid credentials.");
            }
            CustomUserDetail userDetail=new CustomUserDetail(authResponse.getId(),authResponse.getUsername(),password,authResponse.getNames(),authResponse.getEmail());
            return new UsernamePasswordAuthenticationToken(userDetail, password, userDetail.getAuthorities());
        }catch (HttpClientErrorException  ex){
            throw new BadCredentialsException( extractErrorMessageFromException(ex));
        }catch (Exception  ex){
        throw new BadCredentialsException("Error Connection to service");
    }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private String extractErrorMessageFromException(HttpClientErrorException e)  {
        try {
             ErrorResponse errorResponse = objectMapper.readValue(e.getResponseBodyAsString(), new TypeReference<ErrorResponse>() {});
             return errorResponse.getMessage();
        } catch (JsonProcessingException ex) {
             throw new BadCredentialsException("Error al procesar la respuesta JSON: "+ e.getResponseBodyAsString());
        }
    }

}
