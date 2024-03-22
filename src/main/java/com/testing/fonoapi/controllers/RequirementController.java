package com.testing.fonoapi.controllers;

import com.testing.fonoapi.domain.dto.ReqTypeDTO;
import com.testing.fonoapi.domain.dto.RequirementDTO;
import com.testing.fonoapi.domain.requests.CreateReqRequest;
import com.testing.fonoapi.services.RequirementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/req")
@RequiredArgsConstructor
public class RequirementController {
    private final RequirementService requirementService;

    @GetMapping("/types")
    public ResponseEntity<List<ReqTypeDTO>> getAllReqTypes() {
        return ResponseEntity.ok(requirementService.getAllReqTypes());
    }

    @GetMapping
    public ResponseEntity<List<RequirementDTO>> getAllReq() {
        return ResponseEntity.ok(requirementService.getAllReq());
    }

    @PostMapping
    public ResponseEntity<RequirementDTO> addRequirement(@RequestBody @Valid CreateReqRequest request) {
        RequirementDTO requirementDTO = requirementService.add(request);
        return new ResponseEntity<>(requirementDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delRequirement(@PathVariable Long id) {
        requirementService.del(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
