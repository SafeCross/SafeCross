package com.safeCrossApi.controller;

import com.safeCrossApi.dto.LogSyncRequestDTO;
import com.safeCrossApi.dto.LogSyncResponseDTO;
import com.safeCrossApi.service.LogSyncService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/safecross/v1/log-sync")
@Tag(name = "Log de Sincronização", description = "APIs para logs de sincronização de dados")
public class LogSyncController {

    @Autowired
    private LogSyncService logSyncService;

    @Operation(summary = "Registrar log de sincronização")
    @PostMapping
    public ResponseEntity<LogSyncResponseDTO> postSyncLog(@RequestBody LogSyncRequestDTO dto) {
        LogSyncResponseDTO response = logSyncService.saveSyncLog(dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Listar logs de sincronização de um usuário")
    @GetMapping("/{userId}")
    public ResponseEntity<List<LogSyncResponseDTO>> getAllSyncLogs(@PathVariable Long userId) {
        List<LogSyncResponseDTO> logs = logSyncService.listSyncLogsForUser(userId);
        return ResponseEntity.ok(logs);
    }
}