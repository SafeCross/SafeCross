package com.safeCrossApi.service.impl;

import com.safeCrossApi.dto.SyncRequestDTO;
import com.safeCrossApi.dto.SyncResponseDTO;
import com.safeCrossApi.model.LogSyncModel;
import com.safeCrossApi.model.UserModel;
import com.safeCrossApi.repository.LogSyncRepository;
import com.safeCrossApi.repository.UserRepository;
import com.safeCrossApi.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SyncServiceImpl implements SyncService {

    @Autowired
    private LogSyncRepository logSyncRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public SyncResponseDTO sync(SyncRequestDTO dto) {
        UserModel user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        LogSyncModel log = new LogSyncModel();
        log.setUser(user);
        log.setSyncDateTime(LocalDateTime.now());
        log.setExchangedRecordsCount(dto.getExchangedRecordsCount());

        LogSyncModel saved = logSyncRepository.save(log);

        return new SyncResponseDTO(
                saved.getId(),
                saved.getUser().getId(),
                saved.getSyncDateTime(),
                saved.getExchangedRecordsCount()
        );
    }
}