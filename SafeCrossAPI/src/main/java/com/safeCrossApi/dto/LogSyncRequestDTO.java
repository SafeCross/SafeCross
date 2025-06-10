package com.safeCrossApi.dto;

public class LogSyncRequestDTO {
    private Long userId;
    private Integer exchangedRecordsCount;

    public LogSyncRequestDTO() {}

    public LogSyncRequestDTO(Long userId, Integer exchangedRecordsCount) {
        this.userId = userId;
        this.exchangedRecordsCount = exchangedRecordsCount;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Integer getExchangedRecordsCount() { return exchangedRecordsCount; }
    public void setExchangedRecordsCount(Integer exchangedRecordsCount) { this.exchangedRecordsCount = exchangedRecordsCount; }
}