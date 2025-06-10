package com.safeCrossApi.controller;

import com.safeCrossApi.dto.ComputerVisionLogRequestDTO;
import com.safeCrossApi.dto.ComputerVisionLogResponseDTO;
import com.safeCrossApi.service.ComputerVisionLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/safecross/v1/visualization-camera")
@Tag(name = "Visualização Câmera (RA)", description = "APIs para visualização com câmera e log computacional")
public class ComputerVisionLogController {

    @Autowired
    private ComputerVisionLogService computerVisionLogService;

    @Operation(summary = "Registrar log de visualização de câmera com RA")
    @PostMapping
    public ResponseEntity<ComputerVisionLogResponseDTO> postCameraVisualization(@RequestBody ComputerVisionLogRequestDTO dto) {
        ComputerVisionLogResponseDTO response = computerVisionLogService.createLog(dto);
        return ResponseEntity.ok(response);
    }
}