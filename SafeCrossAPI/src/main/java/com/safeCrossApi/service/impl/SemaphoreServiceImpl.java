package com.safeCrossApi.service.impl;

import com.safeCrossApi.dto.ModeledSemaphoreRequestDTO;
import com.safeCrossApi.dto.ModeledSemaphoreResponseDTO;
import com.safeCrossApi.model.ModeledSemaphoreModel;
import com.safeCrossApi.repository.ModeledSemaphoreRespository;
import com.safeCrossApi.service.SemaphoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SemaphoreServiceImpl implements SemaphoreService {
    @Autowired
    private ModeledSemaphoreRespository modeledSemaphoreRespository;
    @Override
    public ModeledSemaphoreResponseDTO findByLatitudeAndLongitude(ModeledSemaphoreRequestDTO requestDTO) {
        ModeledSemaphoreModel modeledSemaphoreModel = modeledSemaphoreRespository
                .findByLatitudeAndLongitude(requestDTO.getLatitude(), requestDTO.getLongitude())
                .orElse(null);

        if (modeledSemaphoreModel == null) {
            return null;
        }

        return new ModeledSemaphoreResponseDTO(
                modeledSemaphoreModel.getId(),
                modeledSemaphoreModel.getLatitude(),
                modeledSemaphoreModel.getLongitude(),
                modeledSemaphoreModel.getLocationDescription(),
                modeledSemaphoreModel.getGreenTime(),
                modeledSemaphoreModel.getYellowTime(),
                modeledSemaphoreModel.getRedTime(),
                modeledSemaphoreModel.getLastUpdate()
        );
    };

    @Override
    public ModeledSemaphoreResponseDTO findSemaphoreById(Long id){
        Optional<ModeledSemaphoreModel> modeledSemaphoreModelOpt = modeledSemaphoreRespository.findById(id);

        if (modeledSemaphoreModelOpt.isEmpty()) {
            return null;
        }

        ModeledSemaphoreModel modeledSemaphoreModel = modeledSemaphoreModelOpt.get();

        return new ModeledSemaphoreResponseDTO(
                modeledSemaphoreModel.getId(),
                modeledSemaphoreModel.getLatitude(),
                modeledSemaphoreModel.getLongitude(),
                modeledSemaphoreModel.getLocationDescription(),
                modeledSemaphoreModel.getGreenTime(),
                modeledSemaphoreModel.getYellowTime(),
                modeledSemaphoreModel.getRedTime(),
                modeledSemaphoreModel.getLastUpdate()
        );
    }

}
