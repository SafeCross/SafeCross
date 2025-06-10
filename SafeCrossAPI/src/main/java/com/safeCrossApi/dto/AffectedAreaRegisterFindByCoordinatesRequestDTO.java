package com.safeCrossApi.dto;

public class AffectedAreaRegisterFindByCoordinatesRequestDTO {
    private String latitude;
    private String longitude;

    public AffectedAreaRegisterFindByCoordinatesRequestDTO() {}

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
}