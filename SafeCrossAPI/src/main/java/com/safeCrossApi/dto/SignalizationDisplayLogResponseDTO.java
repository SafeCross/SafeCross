package com.safeCrossApi.dto;

import java.time.LocalDateTime;

public class SignalizationDisplayLogResponseDTO {
    private Long id;
    private Long userId;
    private Long semaphoreId;
    private LocalDateTime displayDateTime;
    private String visualizationTypeDescription;

    public SignalizationDisplayLogResponseDTO() {}

    public SignalizationDisplayLogResponseDTO(Long id, Long userId, Long semaphoreId, LocalDateTime displayDateTime, String visualizationTypeDescription) {
        this.id = id;
        this.userId = userId;
        this.semaphoreId = semaphoreId;
        this.displayDateTime = displayDateTime;
        this.visualizationTypeDescription = visualizationTypeDescription;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getSemaphoreId() { return semaphoreId; }
    public void setSemaphoreId(Long semaphoreId) { this.semaphoreId = semaphoreId; }

    public LocalDateTime getDisplayDateTime() { return displayDateTime; }
    public void setDisplayDateTime(LocalDateTime displayDateTime) { this.displayDateTime = displayDateTime; }

    public String getVisualizationTypeDescription() { return visualizationTypeDescription; }
    public void setVisualizationTypeDescription(String visualizationTypeDescription) { this.visualizationTypeDescription = visualizationTypeDescription; }
}