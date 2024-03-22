package com.testing.fonoapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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

    public static RequirementDTO builder() {
        return new RequirementDTO();
    }

    public RequirementDTO setReqId(Long reqId) {
        this.reqId = reqId;
        return this;
    }

    public RequirementDTO setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
        return this;
    }

    public RequirementDTO setInventoryDTO(InventoryDTO inventoryDTO) {
        this.inventoryDTO = inventoryDTO;
        return this;
    }

    public RequirementDTO setReqTypeDTO(ReqTypeDTO reqTypeDTO) {
        this.reqTypeDTO = reqTypeDTO;
        return this;
    }

    public RequirementDTO setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public RequirementDTO build() {
        return this;
    }
}
