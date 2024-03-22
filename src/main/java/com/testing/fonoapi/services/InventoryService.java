package com.testing.fonoapi.services;

import com.testing.fonoapi.domain.dto.DeviceDTO;
import com.testing.fonoapi.domain.dto.InventoryDTO;
import com.testing.fonoapi.repositories.DeviceRepository;
import com.testing.fonoapi.repositories.InventoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;

    public List<DeviceDTO> getAllDevices() {
        return deviceRepository.findAll()
                .stream()
                .map(device -> modelMapper.map(device, DeviceDTO.class))
                .collect(Collectors.toList());
    }

    public List<InventoryDTO> getAllInventory() {
        return inventoryRepository.findAll()
                .stream()
                .map(inventory ->
                        InventoryDTO.builder()
                                .deviceId(inventory.getDevice().getDeviceId())
                                .deviceDTO(modelMapper.map(inventory.getDevice(), DeviceDTO.class))
                                .quantity(inventory.getQuantity())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
