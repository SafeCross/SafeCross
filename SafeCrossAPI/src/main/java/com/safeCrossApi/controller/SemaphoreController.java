package com.safeCrossApi.controller;

import com.safeCrossApi.dto.ModeledSemaphoreRequestDTO;
import com.safeCrossApi.dto.ModeledSemaphoreResponseDTO;
import com.safeCrossApi.service.SemaphoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/safecross/v1/semaphores")
@Tag(name = "Semáforos", description = "APIs para consulta e busca de semáforos modelados")
public class SemaphoreController {
    @Autowired
    private SemaphoreService semaphoreService;

    @Operation(summary = "Buscar semáforo por coordenadas")
    @PostMapping("/find")
    public ResponseEntity<ModeledSemaphoreResponseDTO> findByCoordinates(@RequestBody ModeledSemaphoreRequestDTO requestDTO) {
        ModeledSemaphoreResponseDTO response = semaphoreService.findByLatitudeAndLongitude(requestDTO);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Buscar semáforo por ID")
    @GetMapping("/{id}")
    public ModeledSemaphoreResponseDTO findySemaphoreById(@PathVariable Long id){
        return semaphoreService.findSemaphoreById(id);
    }
}