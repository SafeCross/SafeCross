package com.safeCrossApi.controller;

import com.safeCrossApi.dto.SignalizationDisplayLogRequestDTO;
import com.safeCrossApi.dto.SignalizationDisplayLogResponseDTO;
import com.safeCrossApi.service.SignalizationDisplayLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/safecross/v1/logs/sinalization")
@Tag(name = "Logs de Sinalização", description = "APIs para logs de sinalização exibida ao usuário")
public class SignalizationDisplayLogController {

    @Autowired
    private SignalizationDisplayLogService signalizationDisplayLogService;

    @Operation(summary = "Listar logs de sinalização exibida ao usuário")
    @GetMapping
    public ResponseEntity<List<SignalizationDisplayLogResponseDTO>> listLogs(@RequestParam Long userId) {
        return ResponseEntity.ok(signalizationDisplayLogService.listLogsForUser(userId));
    }

    @Operation(summary = "Registrar exibição de sinalização ao usuário")
    @PostMapping
    public ResponseEntity<SignalizationDisplayLogResponseDTO> createLog(@RequestBody SignalizationDisplayLogRequestDTO dto) {
        SignalizationDisplayLogResponseDTO response = signalizationDisplayLogService.createLog(dto);
        return ResponseEntity.ok(response);
    }
}