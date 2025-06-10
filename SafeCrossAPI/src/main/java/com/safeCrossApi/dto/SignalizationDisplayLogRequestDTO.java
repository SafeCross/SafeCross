package com.safeCrossApi.dto;

public class SignalizationDisplayLogRequestDTO {
    private Long userId;
    private Long semaphoreId;
    private Long visualizationTypeId;

    public SignalizationDisplayLogRequestDTO() {}

    public SignalizationDisplayLogRequestDTO(Long userId, Long semaphoreId, Long visualizationTypeId) {
        this.userId = userId;
        this.semaphoreId = semaphoreId;
        this.visualizationTypeId = visualizationTypeId;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getSemaphoreId() { return semaphoreId; }
    public void setSemaphoreId(Long semaphoreId) { this.semaphoreId = semaphoreId; }

    public Long getVisualizationTypeId() { return visualizationTypeId; }
    public void setVisualizationTypeId(Long visualizationTypeId) { this.visualizationTypeId = visualizationTypeId; }
}