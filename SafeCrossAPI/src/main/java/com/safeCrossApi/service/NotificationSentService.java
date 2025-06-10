package com.safeCrossApi.service;

import com.safeCrossApi.dto.NotificationSentRequestDTO;
import com.safeCrossApi.dto.NotificationSentResponseDTO;
import com.safeCrossApi.dto.NotificationTypeRequestDTO;
import com.safeCrossApi.dto.NotificationTypeResponseDTO;

import java.util.List;

public interface NotificationSentService {
    List<NotificationSentResponseDTO> listNotificationsForUser(Long userId);
    void deleteAllNotificationsForUser(Long userId);
    NotificationSentResponseDTO sendNotification(NotificationSentRequestDTO dto);
    NotificationTypeResponseDTO create(NotificationTypeRequestDTO dto);
    List<NotificationTypeResponseDTO> listAllNotificationType();
    NotificationSentResponseDTO getById(Long id);
}