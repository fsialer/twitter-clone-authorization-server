package com.fernando.ms.auth.app.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auth{
    private String username;
    private String password;
}
