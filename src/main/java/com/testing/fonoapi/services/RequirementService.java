package com.testing.fonoapi.services;

import com.testing.fonoapi.domain.dto.ReqTypeDTO;
import com.testing.fonoapi.repositories.RequirementTypeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequirementService {
    private final RequirementTypeRepository reqTypeRepository;
    private final ModelMapper modelMapper;

    public List<ReqTypeDTO> getAllReqTypes() {
        return reqTypeRepository.findAll()
                .stream()
                .map(reqType -> modelMapper.map(reqType, ReqTypeDTO.class))
                .collect(Collectors.toList());
    }
}
