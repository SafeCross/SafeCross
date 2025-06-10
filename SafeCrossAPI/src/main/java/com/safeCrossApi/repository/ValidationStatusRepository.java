package com.safeCrossApi.repository;

import com.safeCrossApi.model.ValidationStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationStatusRepository extends JpaRepository<ValidationStatusModel, Long> {
}
