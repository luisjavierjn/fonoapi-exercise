package com.testing.fonoapi.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InventoryDTO {
    private Long deviceId;
    private DeviceDTO deviceDTO;
    private Integer quantity;
}
