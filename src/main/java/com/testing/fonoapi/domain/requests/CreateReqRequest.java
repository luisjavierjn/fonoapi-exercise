package com.testing.fonoapi.domain.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateReqRequest {
    @NotEmpty(message = "User email should not be empty")
    private String userEmail;
    @NotEmpty(message = "Requirement type should not be empty")
    private String reqTypeName;
    @NotEmpty(message = "Device name should not be empty")
    private String deviceName;
}
