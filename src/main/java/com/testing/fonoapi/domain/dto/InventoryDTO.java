package com.testing.fonoapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InventoryDTO {
    private Long deviceId;
    @JsonProperty("device")
    private DeviceDTO deviceDTO;
    private Integer quantity;
}
