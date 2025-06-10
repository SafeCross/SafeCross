package com.safeCrossApi.repository;

import com.safeCrossApi.model.SignalizationDisplayLogModel;
import com.safeCrossApi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignalizationDisplayLogRepository extends JpaRepository<SignalizationDisplayLogModel, Long> {
    List<SignalizationDisplayLogModel> findByUser(UserModel user);
}