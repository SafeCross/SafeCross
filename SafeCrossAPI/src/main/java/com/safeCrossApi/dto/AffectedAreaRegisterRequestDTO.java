package com.safeCrossApi.dto;


public class AffectedAreaRegisterRequestDTO {
    private Long userId;
    private String latitude;
    private String longitude;
    private String description;
    private Long validationStatusId;

    public AffectedAreaRegisterRequestDTO() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getValidationStatusId() { return validationStatusId; }
    public void setValidationStatusId(Long validationStatusId) { this.validationStatusId = validationStatusId; }
}