package com.safeCrossApi.dto;

import java.time.LocalDateTime;

public class ModeledSemaphoreResponseDTO {
    private Long id;
    private String latitude;
    private String longitude;
    private String locationDescription;
    private Integer greenTime;
    private Integer yellowTime;
    private Integer redTime;
    private LocalDateTime lastUpdate;

    public ModeledSemaphoreResponseDTO() {}

    public ModeledSemaphoreResponseDTO(Long id, String latitude, String longitude, String locationDescription, Integer greenTime, Integer yellowTime, Integer redTime, LocalDateTime lastUpdate) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDescription = locationDescription;
        this.greenTime = greenTime;
        this.yellowTime = yellowTime;
        this.redTime = redTime;
        this.lastUpdate = lastUpdate;
    }

    public ModeledSemaphoreResponseDTO(String latitude, String longitude, String locationDescription, Integer greenTime, Integer yellowTime, Integer redTime, LocalDateTime lastUpdate) {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public String getLocationDescription() { return locationDescription; }
    public void setLocationDescription(String locationDescription) { this.locationDescription = locationDescription; }

    public Integer getGreenTime() { return greenTime; }
    public void setGreenTime(Integer greenTime) { this.greenTime = greenTime; }

    public Integer getYellowTime() { return yellowTime; }
    public void setYellowTime(Integer yellowTime) { this.yellowTime = yellowTime; }

    public Integer getRedTime() { return redTime; }
    public void setRedTime(Integer redTime) { this.redTime = redTime; }

    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }
}