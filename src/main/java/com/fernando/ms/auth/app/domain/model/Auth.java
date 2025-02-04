package com.fernando.ms.auth.app.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auth extends User{
    private String username;
    private String password;
}
