package com.safeCrossApi.service.impl;

import com.safeCrossApi.dto.ComputerVisionLogRequestDTO;
import com.safeCrossApi.dto.ComputerVisionLogResponseDTO;
import com.safeCrossApi.model.ComputerVisionLogModel;
import com.safeCrossApi.model.DetectionResultModel;
import com.safeCrossApi.model.ModeledSemaphoreModel;
import com.safeCrossApi.model.UserModel;
import com.safeCrossApi.repository.ComputerVisionLogRepository;
import com.safeCrossApi.repository.DetectionResultRepository;
import com.safeCrossApi.repository.ModeledSemaphoreRespository;
import com.safeCrossApi.repository.UserRepository;
import com.safeCrossApi.service.ComputerVisionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ComputerVisionLogServiceImpl implements ComputerVisionLogService {

    @Autowired
    private ModeledSemaphoreRespository modeledSemaphoreRepository;
    @Autowired
    private DetectionResultRepository detectionResultRepository;
    @Autowired
    private ComputerVisionLogRepository computerVisionLogRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ComputerVisionLogResponseDTO createLog(ComputerVisionLogRequestDTO dto) {
        UserModel user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ModeledSemaphoreModel semaphore = modeledSemaphoreRepository
                .findByLatitudeAndLongitude(dto.getLatitude(), dto.getLongitude())
                .orElseThrow(() -> new RuntimeException("Semáforo não encontrado"));

        DetectionResultModel detectionResult = detectionResultRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Resultado de detecção não encontrado"));

        ComputerVisionLogModel log = new ComputerVisionLogModel();
        log.setUser(user);
        log.setSemaphore(semaphore);
        log.setUsageDateTime(LocalDateTime.now());
        log.setDetectionResult(detectionResult);

        computerVisionLogRepository.save(log);

        return new ComputerVisionLogResponseDTO(
                semaphore.getId(),
                semaphore.getLocationDescription(),
                detectionResult.getDescription()
        );
    }
}