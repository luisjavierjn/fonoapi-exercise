package com.testing.fonoapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.testing.fonoapi.domain.entities.Device;
import com.testing.fonoapi.domain.entities.Inventory;
import com.testing.fonoapi.domain.entities.ReqType;
import com.testing.fonoapi.domain.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class RequirementDTO {
    private Long reqId;
    @JsonProperty("user")
    private UserDTO userDTO;
    @JsonIgnore
    private InventoryDTO inventoryDTO;
    @JsonIgnore
    private ReqTypeDTO reqTypeDTO;
    private LocalDateTime dateTime;

    public String getService() {
        return reqTypeDTO.getName();
    }

    public DeviceDTO getDevice() {
        return inventoryDTO.getDeviceDTO();
    }

    public Boolean getAvailable() {
        return inventoryDTO.getQuantity() > 0;
    }
}
