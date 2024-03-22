package com.testing.fonoapi.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeviceDTO {
    private Long deviceId;
    private String name;
    private String brand;
    private String technology;
    private String _2gBands;
    private String _3gBands;
    private String _4gBands;
}
