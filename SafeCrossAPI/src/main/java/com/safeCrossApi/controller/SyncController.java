package com.safeCrossApi.controller;

import com.safeCrossApi.dto.SyncRequestDTO;
import com.safeCrossApi.dto.SyncResponseDTO;
import com.safeCrossApi.service.SyncService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/safecross/v1/logs/sync")
@Tag(name = "Sincronização Local", description = "API para sincronização local de semáforos e áreas afetadas")
public class SyncController {

    @Autowired
    private SyncService syncService;

    @Operation(summary = "Sincronizar dados locais entre dispositivos")
    @PostMapping
    public ResponseEntity<SyncResponseDTO> sync(@RequestBody SyncRequestDTO dto) {
        SyncResponseDTO response = syncService.sync(dto);
        return ResponseEntity.ok(response);
    }
}