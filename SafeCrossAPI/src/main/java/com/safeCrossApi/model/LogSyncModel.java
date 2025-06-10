package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_sincronizacao")
public class LogSyncModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_sync")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel user;

    @Column(name = "data_hora_sync")
    private LocalDateTime syncDateTime;

    @Column(name = "quantidade_registros_trocados")
    private Integer exchangedRecordsCount;

    public LogSyncModel() {}

    public LogSyncModel(Long id, UserModel user, LocalDateTime syncDateTime, Integer exchangedRecordsCount) {
        this.id = id;
        this.user = user;
        this.syncDateTime = syncDateTime;
        this.exchangedRecordsCount = exchangedRecordsCount;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserModel getUser() { return user; }
    public void setUser(UserModel user) { this.user = user; }

    public LocalDateTime getSyncDateTime() { return syncDateTime; }
    public void setSyncDateTime(LocalDateTime syncDateTime) { this.syncDateTime = syncDateTime; }

    public Integer getExchangedRecordsCount() { return exchangedRecordsCount; }
    public void setExchangedRecordsCount(Integer exchangedRecordsCount) { this.exchangedRecordsCount = exchangedRecordsCount; }
}