package com.fernando.ms.auth.app.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String names;
    private String email;
    private String username;
    private String password;
}
