package com.safeCrossApi.repository;

import com.safeCrossApi.model.ComputerVisionLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerVisionLogRepository extends JpaRepository<ComputerVisionLogModel, Long> {
}
