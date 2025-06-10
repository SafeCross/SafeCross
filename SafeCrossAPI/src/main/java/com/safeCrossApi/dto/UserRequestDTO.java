package com.safeCrossApi.dto;

public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private String deviceId;

    public UserRequestDTO() {}

    public UserRequestDTO(String name, String email, String password, String deviceId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.deviceId = deviceId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
}