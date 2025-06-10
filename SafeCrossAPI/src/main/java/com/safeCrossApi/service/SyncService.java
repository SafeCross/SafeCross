package com.safeCrossApi.service;

import com.safeCrossApi.dto.SyncRequestDTO;
import com.safeCrossApi.dto.SyncResponseDTO;

public interface SyncService {
    SyncResponseDTO sync(SyncRequestDTO dto);
}