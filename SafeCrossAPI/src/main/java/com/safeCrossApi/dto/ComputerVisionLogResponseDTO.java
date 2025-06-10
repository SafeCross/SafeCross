package com.safeCrossApi.dto;

public class ComputerVisionLogResponseDTO {
    private Long semaphoreId;
    private String semaphoreLocationDescription;
    private String detectionResultDescription;

    public ComputerVisionLogResponseDTO() {}

    public ComputerVisionLogResponseDTO(Long semaphoreId, String semaphoreLocationDescription, String detectionResultDescription) {
        this.semaphoreId = semaphoreId;
        this.semaphoreLocationDescription = semaphoreLocationDescription;
        this.detectionResultDescription = detectionResultDescription;
    }

    public Long getSemaphoreId() { return semaphoreId; }
    public void setSemaphoreId(Long semaphoreId) { this.semaphoreId = semaphoreId; }

    public String getSemaphoreLocationDescription() { return semaphoreLocationDescription; }
    public void setSemaphoreLocationDescription(String semaphoreLocationDescription) { this.semaphoreLocationDescription = semaphoreLocationDescription; }

    public String getDetectionResultDescription() { return detectionResultDescription; }
    public void setDetectionResultDescription(String detectionResultDescription) { this.detectionResultDescription = detectionResultDescription; }
}