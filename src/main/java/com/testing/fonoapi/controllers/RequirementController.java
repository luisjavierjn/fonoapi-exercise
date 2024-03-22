package com.testing.fonoapi.controllers;

import com.testing.fonoapi.domain.dto.ReqTypeDTO;
import com.testing.fonoapi.services.RequirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/req")
@RequiredArgsConstructor
public class RequirementController {
    private final RequirementService requirementService;

    @GetMapping("/types")
    public ResponseEntity<List<ReqTypeDTO>> getAllDevices() {
        return ResponseEntity.ok(requirementService.getAllReqTypes());
    }
}
