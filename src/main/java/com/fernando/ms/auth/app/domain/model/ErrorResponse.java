package com.fernando.ms.auth.app.domain.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String code;
    private String type;
    private String message;
    private List<String> details;
    private String timestamp;
}
