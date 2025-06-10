package com.safeCrossApi.repository;

import com.safeCrossApi.model.LogSyncModel;
import com.safeCrossApi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogSyncRepository extends JpaRepository<LogSyncModel, Long> {
    List<LogSyncModel> findByUser(UserModel user);
}