package com.testing.fonoapi.services;

import com.testing.fonoapi.domain.dto.DeviceDTO;
import com.testing.fonoapi.repositories.DeviceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;

    public List<DeviceDTO> getAllPrices() {
        return deviceRepository.findAll()
                .stream()
                .map(price -> modelMapper.map(price, DeviceDTO.class))
                .collect(Collectors.toList());
    }
}
