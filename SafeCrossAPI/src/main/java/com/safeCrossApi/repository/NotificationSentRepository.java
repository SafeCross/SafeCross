package com.safeCrossApi.repository;

import com.safeCrossApi.model.NotificationSentModel;
import com.safeCrossApi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationSentRepository extends JpaRepository<NotificationSentModel, Long> {
    List<NotificationSentModel> findByUser(UserModel user);
    void deleteByUser(UserModel user);
}