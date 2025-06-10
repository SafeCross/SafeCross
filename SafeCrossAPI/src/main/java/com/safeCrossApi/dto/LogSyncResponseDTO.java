package com.safeCrossApi.dto;

import java.time.LocalDateTime;

public class LogSyncResponseDTO {
    private Long id;
    private Long userId;
    private LocalDateTime syncDateTime;
    private Integer exchangedRecordsCount;

    public LogSyncResponseDTO() {}

    public LogSyncResponseDTO(Long id, Long userId, LocalDateTime syncDateTime, Integer exchangedRecordsCount) {
        this.id = id;
        this.userId = userId;
        this.syncDateTime = syncDateTime;
        this.exchangedRecordsCount = exchangedRecordsCount;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDateTime getSyncDateTime() { return syncDateTime; }
    public void setSyncDateTime(LocalDateTime syncDateTime) { this.syncDateTime = syncDateTime; }

    public Integer getExchangedRecordsCount() { return exchangedRecordsCount; }
    public void setExchangedRecordsCount(Integer exchangedRecordsCount) { this.exchangedRecordsCount = exchangedRecordsCount; }
}