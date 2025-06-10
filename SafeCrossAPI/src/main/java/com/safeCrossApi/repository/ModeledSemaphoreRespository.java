package com.safeCrossApi.repository;

import com.safeCrossApi.model.ModeledSemaphoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeledSemaphoreRespository extends JpaRepository<ModeledSemaphoreModel, Long> {
    Optional<ModeledSemaphoreModel> findByLatitudeAndLongitude(String latitude, String longitude);
}
