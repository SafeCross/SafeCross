package com.safeCrossApi.service.impl;

import com.safeCrossApi.dto.AffectedAreaRegisterFindByCoordinatesRequestDTO;
import com.safeCrossApi.dto.AffectedAreaRegisterRequestDTO;
import com.safeCrossApi.dto.AffectedAreaRegisterResponseDTO;
import com.safeCrossApi.model.AffectedAreaRegisterModel;
import com.safeCrossApi.model.UserModel;
import com.safeCrossApi.model.ValidationStatusModel;
import com.safeCrossApi.repository.AffectedAreaRegisterRepository;
import com.safeCrossApi.repository.UserRepository;
import com.safeCrossApi.repository.ValidationStatusRepository;
import com.safeCrossApi.service.AffectedAreaRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AffectedAreaRegisterServiceImpl implements AffectedAreaRegisterService {
    @Autowired
    AffectedAreaRegisterRepository affectedAreaRegisterRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationStatusRepository validationStatusRepository;

    @Override
    public AffectedAreaRegisterResponseDTO register(AffectedAreaRegisterRequestDTO requestDTO) {
        UserModel user = userRepository.findById(requestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        ValidationStatusModel validationStatus = validationStatusRepository.findById(requestDTO.getValidationStatusId()).orElseThrow(() -> new RuntimeException("Validation status not found"));

        AffectedAreaRegisterModel model = new AffectedAreaRegisterModel();
        model.setUser(user);
        model.setLatitude(requestDTO.getLatitude());
        model.setLongitude(requestDTO.getLongitude());
        model.setRegisterDateTime(LocalDateTime.now());
        model.setDescription(requestDTO.getDescription());
        model.setValidationStatus(validationStatus);

        AffectedAreaRegisterModel saved = affectedAreaRegisterRepository.save(model);

        return new AffectedAreaRegisterResponseDTO(
                saved.getId(),
                saved.getUser().getId(),
                saved.getLatitude(),
                saved.getLongitude(),
                saved.getRegisterDateTime(),
                saved.getDescription(),
                saved.getValidationStatus().getId()
        );
    }

    @Override
    public AffectedAreaRegisterResponseDTO findByLatitudeAndLongitude(AffectedAreaRegisterFindByCoordinatesRequestDTO requestDTO) {
        AffectedAreaRegisterModel model = affectedAreaRegisterRepository
                .findByLatitudeAndLongitude(requestDTO.getLatitude(), requestDTO.getLongitude())
                .orElse(null);

        if (model == null) return null;

        return new AffectedAreaRegisterResponseDTO(
                model.getId(),
                model.getUser().getId(),
                model.getLatitude(),
                model.getLongitude(),
                model.getRegisterDateTime(),
                model.getDescription(),
                model.getValidationStatus().getId()
        );
    }
}
