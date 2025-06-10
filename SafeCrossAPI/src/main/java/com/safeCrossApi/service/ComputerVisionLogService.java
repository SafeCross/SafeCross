package com.safeCrossApi.service;

import com.safeCrossApi.dto.ComputerVisionLogRequestDTO;
import com.safeCrossApi.dto.ComputerVisionLogResponseDTO;

public interface ComputerVisionLogService {
    ComputerVisionLogResponseDTO createLog(ComputerVisionLogRequestDTO dto);
}