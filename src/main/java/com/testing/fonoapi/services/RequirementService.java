package com.testing.fonoapi.services;

import com.testing.fonoapi.domain.dto.DeviceDTO;
import com.testing.fonoapi.domain.dto.InventoryDTO;
import com.testing.fonoapi.domain.dto.ReqTypeDTO;
import com.testing.fonoapi.domain.dto.RequirementDTO;
import com.testing.fonoapi.domain.dto.UserDTO;
import com.testing.fonoapi.repositories.RequirementRepository;
import com.testing.fonoapi.repositories.RequirementTypeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequirementService {
    private final RequirementRepository reqRepository;
    private final RequirementTypeRepository reqTypeRepository;
    private final ModelMapper modelMapper;

    public List<ReqTypeDTO> getAllReqTypes() {
        return reqTypeRepository.findAll()
                .stream()
                .map(reqType -> modelMapper.map(reqType, ReqTypeDTO.class))
                .collect(Collectors.toList());
    }

    public List<RequirementDTO> getAllReq() {
        return reqRepository.findAll()
                .stream()
                .map(req ->
                    RequirementDTO.builder()
                            .reqId(req.getReqId())
                            .userDTO(modelMapper.map(req.getUser(), UserDTO.class))
                            .inventoryDTO(
                                    InventoryDTO.builder()
                                            .deviceId(req.getInventory().getDevice().getDeviceId())
                                            .deviceDTO(modelMapper.map(req.getInventory().getDevice(), DeviceDTO.class))
                                            .quantity(req.getInventory().getQuantity())
                                            .build()
                            )
                            .reqTypeDTO(modelMapper.map(req.getReqType(), ReqTypeDTO.class))
                            .dateTime(req.getDateTime())
                            .build()
                )
                .collect(Collectors.toList());
    }
}
