package com.safeCrossApi.repository;

import com.safeCrossApi.model.DetectionResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectionResultRepository extends JpaRepository<DetectionResultModel, Long> {
}
