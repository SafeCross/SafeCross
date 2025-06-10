package com.safeCrossApi.service.impl;

import com.safeCrossApi.dto.NotificationSentRequestDTO;
import com.safeCrossApi.dto.NotificationSentResponseDTO;
import com.safeCrossApi.dto.NotificationTypeRequestDTO;
import com.safeCrossApi.dto.NotificationTypeResponseDTO;
import com.safeCrossApi.model.NotificationSentModel;
import com.safeCrossApi.model.NotificationTypeModel;
import com.safeCrossApi.model.UserModel;
import com.safeCrossApi.repository.NotificationSentRepository;
import com.safeCrossApi.repository.NotificationTypeRepository;
import com.safeCrossApi.repository.UserRepository;
import com.safeCrossApi.service.NotificationSentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationSentServiceImpl implements NotificationSentService {

    @Autowired
    private NotificationSentRepository notificationSentRepository;
    @Autowired
    private NotificationTypeRepository notificationTypeRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<NotificationSentResponseDTO> listNotificationsForUser(Long userId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<NotificationSentModel> notifications = notificationSentRepository.findByUser(user);
        return notifications.stream().map(n ->
                new NotificationSentResponseDTO(
                        n.getId(),
                        n.getNotificationType().getId(),
                        n.getNotificationType().getDescription(),
                        n.getSentDateTime(),
                        n.getTargetLatitude(),
                        n.getTargetLongitude()
                )
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteAllNotificationsForUser(Long userId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        notificationSentRepository.deleteByUser(user);
    }

    @Override
    public NotificationSentResponseDTO sendNotification(NotificationSentRequestDTO dto) {
        UserModel user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        NotificationTypeModel notificationType = notificationTypeRepository.findById(dto.getNotificationTypeId())
                .orElseThrow(() -> new RuntimeException("Tipo de notificação não encontrado"));

        NotificationSentModel model = new NotificationSentModel();
        model.setUser(user);
        model.setNotificationType(notificationType);
        model.setSentDateTime(LocalDateTime.now());
        model.setTargetLatitude(dto.getTargetLatitude());
        model.setTargetLongitude(dto.getTargetLongitude());

        NotificationSentModel saved = notificationSentRepository.save(model);

        return new NotificationSentResponseDTO(
                saved.getId(),
                saved.getNotificationType().getId(),
                saved.getNotificationType().getDescription(),
                saved.getSentDateTime(),
                saved.getTargetLatitude(),
                saved.getTargetLongitude()
        );
    }

    @Override
    public NotificationTypeResponseDTO create(NotificationTypeRequestDTO dto) {
        NotificationTypeModel entity = new NotificationTypeModel();
        entity.setDescription(dto.getDescription());
        NotificationTypeModel saved = notificationTypeRepository.save(entity);
        return new NotificationTypeResponseDTO(saved.getId(), saved.getDescription());
    }

    @Override
    public List<NotificationTypeResponseDTO> listAllNotificationType() {
        return notificationTypeRepository.findAll()
                .stream()
                .map(type -> new NotificationTypeResponseDTO(type.getId(), type.getDescription()))
                .toList();
    }

    @Override
    public NotificationSentResponseDTO getById(Long id) {
        return notificationSentRepository.findById(id)
                .map(n -> new NotificationSentResponseDTO(
                        n.getId(),
                        n.getNotificationType().getId(),
                        n.getNotificationType().getDescription(),
                        n.getSentDateTime(),
                        n.getTargetLatitude(),
                        n.getTargetLongitude()
                ))
                .orElse(null);
    }
}