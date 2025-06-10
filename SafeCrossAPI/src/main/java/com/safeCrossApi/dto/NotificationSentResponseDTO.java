package com.safeCrossApi.dto;

import java.time.LocalDateTime;

public class NotificationSentResponseDTO {
    private Long id;
    private Long notificationTypeId;
    private String notificationTypeDescription;
    private LocalDateTime sentDateTime;
    private String targetLatitude;
    private String targetLongitude;

    public NotificationSentResponseDTO() {}

    public NotificationSentResponseDTO(Long id, Long notificationTypeId, String notificationTypeDescription, LocalDateTime sentDateTime, String targetLatitude, String targetLongitude) {
        this.id = id;
        this.notificationTypeId = notificationTypeId;
        this.notificationTypeDescription = notificationTypeDescription;
        this.sentDateTime = sentDateTime;
        this.targetLatitude = targetLatitude;
        this.targetLongitude = targetLongitude;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getNotificationTypeId() { return notificationTypeId; }
    public void setNotificationTypeId(Long notificationTypeId) { this.notificationTypeId = notificationTypeId; }

    public String getNotificationTypeDescription() { return notificationTypeDescription; }
    public void setNotificationTypeDescription(String notificationTypeDescription) { this.notificationTypeDescription = notificationTypeDescription; }

    public LocalDateTime getSentDateTime() { return sentDateTime; }
    public void setSentDateTime(LocalDateTime sentDateTime) { this.sentDateTime = sentDateTime; }

    public String getTargetLatitude() { return targetLatitude; }
    public void setTargetLatitude(String targetLatitude) { this.targetLatitude = targetLatitude; }

    public String getTargetLongitude() { return targetLongitude; }
    public void setTargetLongitude(String targetLongitude) { this.targetLongitude = targetLongitude; }
}