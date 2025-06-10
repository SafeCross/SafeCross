package com.safeCrossApi.repository;

import com.safeCrossApi.model.AffectedAreaRegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AffectedAreaRegisterRepository extends JpaRepository<AffectedAreaRegisterModel, Long> {
    Optional<AffectedAreaRegisterModel> findByLatitudeAndLongitude(String latitude, String longitude);
}
