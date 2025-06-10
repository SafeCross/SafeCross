package com.safeCrossApi.service.impl;

import com.safeCrossApi.dto.SignalizationDisplayLogRequestDTO;
import com.safeCrossApi.dto.SignalizationDisplayLogResponseDTO;
import com.safeCrossApi.model.ModeledSemaphoreModel;
import com.safeCrossApi.model.SignalizationDisplayLogModel;
import com.safeCrossApi.model.UserModel;
import com.safeCrossApi.model.VisualizationTypeModel;
import com.safeCrossApi.repository.ModeledSemaphoreRespository;
import com.safeCrossApi.repository.SignalizationDisplayLogRepository;
import com.safeCrossApi.repository.UserRepository;
import com.safeCrossApi.repository.VisualizationTypeRepository;
import com.safeCrossApi.service.SignalizationDisplayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SignalizationDisplayLogServiceImpl implements SignalizationDisplayLogService {

    @Autowired
    private SignalizationDisplayLogRepository signalizationDisplayLogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModeledSemaphoreRespository modeledSemaphoreRepository;
    @Autowired
    private VisualizationTypeRepository visualizationTypeRepository;

    @Override
    public List<SignalizationDisplayLogResponseDTO> listLogsForUser(Long userId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<SignalizationDisplayLogModel> logs = signalizationDisplayLogRepository.findByUser(user);
        return logs.stream()
                .map(log -> new SignalizationDisplayLogResponseDTO(
                        log.getId(),
                        log.getUser().getId(),
                        log.getSemaphore().getId(),
                        log.getDisplayDateTime(),
                        log.getVisualizationType().getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public SignalizationDisplayLogResponseDTO createLog(SignalizationDisplayLogRequestDTO dto) {
        UserModel user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        ModeledSemaphoreModel semaphore = modeledSemaphoreRepository.findById(dto.getSemaphoreId())
                .orElseThrow(() -> new RuntimeException("Semáforo não encontrado"));
        VisualizationTypeModel visualizationType = visualizationTypeRepository.findById(dto.getVisualizationTypeId())
                .orElseThrow(() -> new RuntimeException("Tipo de visualização não encontrado"));

        SignalizationDisplayLogModel log = new SignalizationDisplayLogModel();
        log.setUser(user);
        log.setSemaphore(semaphore);
        log.setDisplayDateTime(LocalDateTime.now());
        log.setVisualizationType(visualizationType);

        SignalizationDisplayLogModel saved = signalizationDisplayLogRepository.save(log);

        return new SignalizationDisplayLogResponseDTO(
                saved.getId(),
                saved.getUser().getId(),
                saved.getSemaphore().getId(),
                saved.getDisplayDateTime(),
                saved.getVisualizationType().getDescription()
        );
    }
}