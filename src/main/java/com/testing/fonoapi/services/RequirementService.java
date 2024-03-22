package com.testing.fonoapi.services;

import com.testing.fonoapi.domain.dto.DeviceDTO;
import com.testing.fonoapi.domain.dto.InventoryDTO;
import com.testing.fonoapi.domain.dto.ReqTypeDTO;
import com.testing.fonoapi.domain.dto.RequirementDTO;
import com.testing.fonoapi.domain.dto.UserDTO;
import com.testing.fonoapi.domain.entities.Device;
import com.testing.fonoapi.domain.entities.Requirement;
import com.testing.fonoapi.domain.requests.CreateReqRequest;
import com.testing.fonoapi.repositories.DeviceRepository;
import com.testing.fonoapi.repositories.InventoryRepository;
import com.testing.fonoapi.repositories.RequirementRepository;
import com.testing.fonoapi.repositories.RequirementTypeRepository;
import com.testing.fonoapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequirementService {
    private final DeviceRepository deviceRepository;
    private final InventoryRepository inventoryRepository;
    private final UserRepository userRepository;
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
                .map(this::mapRequirementToRequirementDTO
//                    RequirementDTO.builder()
//                            .setReqId(req.getReqId())
//                            .setUserDTO(modelMapper.map(req.getUser(), UserDTO.class))
//                            .setInventoryDTO(
//                                    InventoryDTO.builder()
//                                            .deviceId(req.getInventory().getDevice().getDeviceId())
//                                            .deviceDTO(modelMapper.map(req.getInventory().getDevice(), DeviceDTO.class))
//                                            .quantity(req.getInventory().getQuantity())
//                                            .build()
//                            )
//                            .setReqTypeDTO(modelMapper.map(req.getReqType(), ReqTypeDTO.class))
//                            .setDateTime(req.getDateTime())
//                            .build()
                )
                .collect(Collectors.toList());
    }

    private RequirementDTO mapRequirementToRequirementDTO(Requirement req) {
        return RequirementDTO.builder()
                .setReqId(req.getReqId())
                .setUserDTO(modelMapper.map(req.getUser(), UserDTO.class))
                .setInventoryDTO(
                        InventoryDTO.builder()
                                .deviceId(req.getInventory().getDevice().getDeviceId())
                                .deviceDTO(modelMapper.map(req.getInventory().getDevice(), DeviceDTO.class))
                                .quantity(req.getInventory().getQuantity())
                                .build()
                )
                .setReqTypeDTO(modelMapper.map(req.getReqType(), ReqTypeDTO.class))
                .setDatetime(req.getDatetime())
                .build();
    }

    public RequirementDTO add(CreateReqRequest request) {
        Requirement requirement = new Requirement();
        requirement.setUser(userRepository.findByEmail(request.getUserEmail()));
        Device device = deviceRepository.findByName(request.getDeviceName());
        requirement.setInventory(inventoryRepository.getByDeviceId(device.getDeviceId()));
        requirement.setReqType(reqTypeRepository.findByName(request.getReqTypeName()));
        requirement.setDatetime(LocalDateTime.now());
        return mapRequirementToRequirementDTO(reqRepository.save(requirement));
    }
}
