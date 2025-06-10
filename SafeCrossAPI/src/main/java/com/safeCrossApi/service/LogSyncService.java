package com.safeCrossApi.service;

import com.safeCrossApi.dto.LogSyncRequestDTO;
import com.safeCrossApi.dto.LogSyncResponseDTO;

import java.util.List;

public interface LogSyncService {
    LogSyncResponseDTO saveSyncLog(LogSyncRequestDTO dto);
    List<LogSyncResponseDTO> listSyncLogsForUser(Long userId);
}