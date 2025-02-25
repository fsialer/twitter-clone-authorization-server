package com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.mapper;

import com.fernando.ms.auth.app.domain.model.User;
import com.fernando.ms.auth.app.infrastructure.adapter.output.restclient.models.response.AuthResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRestClientMapper {
    User toAuth(AuthResponse auth);
}
