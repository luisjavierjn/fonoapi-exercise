package com.testing.fonoapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.testing.fonoapi.domain.entities.Device;
import com.testing.fonoapi.domain.entities.Inventory;
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
    @JsonIgnore
    private Inventory inventory;
    @JsonIgnore
    private ReqType reqType;
    private LocalDateTime dateTime;

    public String getService() {
        return reqType.getName();
    }

    public Device getDevice() {
        return inventory.getDevice();
    }

    public Boolean getAvailable() {
        return inventory.getQuantity() > 0;
    }
}
