package com.safeCrossApi.service;

import com.safeCrossApi.dto.ModeledSemaphoreRequestDTO;
import com.safeCrossApi.dto.ModeledSemaphoreResponseDTO;

public interface SemaphoreService {
    ModeledSemaphoreResponseDTO findByLatitudeAndLongitude(ModeledSemaphoreRequestDTO requestDTO);
    ModeledSemaphoreResponseDTO findSemaphoreById(Long id);
}
