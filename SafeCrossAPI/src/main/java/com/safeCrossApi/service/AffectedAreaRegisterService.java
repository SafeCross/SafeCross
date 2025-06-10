package com.safeCrossApi.service;

import com.safeCrossApi.dto.AffectedAreaRegisterFindByCoordinatesRequestDTO;
import com.safeCrossApi.dto.AffectedAreaRegisterRequestDTO;
import com.safeCrossApi.dto.AffectedAreaRegisterResponseDTO;

public interface AffectedAreaRegisterService {
    AffectedAreaRegisterResponseDTO register(AffectedAreaRegisterRequestDTO requestDTO);
    AffectedAreaRegisterResponseDTO findByLatitudeAndLongitude(AffectedAreaRegisterFindByCoordinatesRequestDTO requestDTO);
}
