package com.safeCrossApi.dto;


public class ModeledSemaphoreRequestDTO {
    private String latitude;
    private String longitude;

    public ModeledSemaphoreRequestDTO() {}

    public ModeledSemaphoreRequestDTO(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}