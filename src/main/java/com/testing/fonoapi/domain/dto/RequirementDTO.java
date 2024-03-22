package com.testing.fonoapi.domain.dto;

import com.testing.fonoapi.domain.entities.Device;
import com.testing.fonoapi.domain.entities.ReqType;
import com.testing.fonoapi.domain.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RequirementDTO {
    private Long reqId;
    private User user;
    private Device device;
    private ReqType reqType;
    private Boolean availability;
    private LocalDateTime dateTime;
}
