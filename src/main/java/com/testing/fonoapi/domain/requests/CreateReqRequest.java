package com.testing.fonoapi.domain.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateReqRequest {
    private String userEmail;
    private String reqTypeName;
    private String deviceName;
}
