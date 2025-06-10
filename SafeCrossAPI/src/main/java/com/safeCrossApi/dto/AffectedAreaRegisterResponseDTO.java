package com.safeCrossApi.dto;

import java.time.LocalDateTime;

public class AffectedAreaRegisterResponseDTO {
    private Long id;
    private Long userId;
    private String latitude;
    private String longitude;
    private LocalDateTime registerDateTime;
    private String description;
    private Long validationStatusId;

    public AffectedAreaRegisterResponseDTO() {}

    public AffectedAreaRegisterResponseDTO(Long id, Long userId, String latitude, String longitude, LocalDateTime registerDateTime, String description, Long validationStatusId) {
        this.id = id;
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.registerDateTime = registerDateTime;
        this.description = description;
        this.validationStatusId = validationStatusId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public LocalDateTime getRegisterDateTime() { return registerDateTime; }
    public void setRegisterDateTime(LocalDateTime registerDateTime) { this.registerDateTime = registerDateTime; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getValidationStatusId() { return validationStatusId; }
    public void setValidationStatusId(Long validationStatusId) { this.validationStatusId = validationStatusId; }
}