package com.safeCrossApi.dto;


public class NotificationSentRequestDTO {
    private Long userId;
    private Long notificationTypeId;
    private String targetLatitude;
    private String targetLongitude;

    public NotificationSentRequestDTO() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getNotificationTypeId() { return notificationTypeId; }
    public void setNotificationTypeId(Long notificationTypeId) { this.notificationTypeId = notificationTypeId; }

    public String getTargetLatitude() { return targetLatitude; }
    public void setTargetLatitude(String targetLatitude) { this.targetLatitude = targetLatitude; }

    public String getTargetLongitude() { return targetLongitude; }
    public void setTargetLongitude(String targetLongitude) { this.targetLongitude = targetLongitude; }
}