package com.safeCrossApi.dto;

public class ComputerVisionLogRequestDTO {
    private Long userId;
    private String latitude;
    private String longitude;
    private Double orientation;

    public ComputerVisionLogRequestDTO() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public Double getOrientation() { return orientation; }
    public void setOrientation(Double orientation) { this.orientation = orientation; }
}