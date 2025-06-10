package com.safeCrossApi.controller;

import com.safeCrossApi.dto.NotificationSentRequestDTO;
import com.safeCrossApi.dto.NotificationSentResponseDTO;
import com.safeCrossApi.dto.NotificationTypeRequestDTO;
import com.safeCrossApi.dto.NotificationTypeResponseDTO;
import com.safeCrossApi.service.NotificationSentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/safecross/v1/notifications")
@Tag(name = "Notificações", description = "APIs para envio e consulta de notificações")
public class NotificationSentController {

    @Autowired
    private NotificationSentService notificationSentService;

    @Operation(summary = "Listar notificações de um usuário")
    @GetMapping("/{userId}")
    public ResponseEntity<List<NotificationSentResponseDTO>> listNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationSentService.listNotificationsForUser(userId));
    }

    @Operation(summary = "Deletar todas as notificações de um usuário")
    @DeleteMapping("/userId")
    public ResponseEntity<Void> deleteAllNotifications(@PathVariable Long userId) {
        notificationSentService.deleteAllNotificationsForUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Enviar notificação")
    @PostMapping("/send")
    public ResponseEntity<NotificationSentResponseDTO> sendNotification(@RequestBody NotificationSentRequestDTO dto) {
        NotificationSentResponseDTO responseDTO = notificationSentService.sendNotification(dto);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Criar um tipo de notificação")
    @PostMapping("/notification-type")
    public ResponseEntity<NotificationTypeResponseDTO> createNotificationType(
            @RequestBody NotificationTypeRequestDTO dto
    ) {
        NotificationTypeResponseDTO responseDTO = notificationSentService.create(dto);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Listar todos tipos de notificação")
    @GetMapping
    public ResponseEntity<List<NotificationTypeResponseDTO>> getNotificationType(){
        return ResponseEntity.ok(notificationSentService.listAllNotificationType());
    }

    @Operation(summary = "Buscar tipo de notificação por ID")
    @GetMapping("notifications-type/{notificationId}")
    public ResponseEntity<NotificationSentResponseDTO> getNotificationById(@PathVariable Long notificationId) {
        NotificationSentResponseDTO notification = notificationSentService.getById(notificationId);
        if (notification == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notification);
    }
}