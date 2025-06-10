package com.safeCrossApi.service;

import com.safeCrossApi.dto.SignalizationDisplayLogRequestDTO;
import com.safeCrossApi.dto.SignalizationDisplayLogResponseDTO;

import java.util.List;

public interface SignalizationDisplayLogService {
    List<SignalizationDisplayLogResponseDTO> listLogsForUser(Long userId);
    SignalizationDisplayLogResponseDTO createLog(SignalizationDisplayLogRequestDTO dto);
}