package com.testing.fonoapi.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeviceDTO {
    private Integer id;
    private String name;
    private String brand;
    private String technology;
    private String _2g_bands;
    private String _3g_bands;
    private String _4g_bands;
}
