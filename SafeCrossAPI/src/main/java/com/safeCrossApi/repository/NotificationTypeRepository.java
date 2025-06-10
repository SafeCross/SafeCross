package com.safeCrossApi.repository;

import com.safeCrossApi.model.NotificationTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationTypeRepository extends JpaRepository<NotificationTypeModel, Long> {
}