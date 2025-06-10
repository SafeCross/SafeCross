package com.safeCrossApi.repository;

import com.safeCrossApi.model.VisualizationTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualizationTypeRepository extends JpaRepository<VisualizationTypeModel, Long> {
}
