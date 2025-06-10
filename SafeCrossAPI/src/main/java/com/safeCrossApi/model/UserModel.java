package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "senha_hash", length = 255, nullable = false)
    private String passwordHash;

    @Column(name = "data_cadastro")
    private LocalDateTime registrationDate;

    @Column(name = "dispositivo_id", length = 100)
    private String deviceId;

    @OneToMany(mappedBy = "user")
    private List<AffectedAreaRegisterModel> affectedAreaRegisters;

    @OneToMany(mappedBy = "user")
    private List<LogSyncModel> logSyncs;

    @OneToMany(mappedBy = "user")
    private List<NotificationSentModel> notificationsSent;

    @OneToMany(mappedBy = "user")
    private List<SignalizationDisplayLogModel> signalizationDisplayLogs;

    @OneToMany(mappedBy = "user")
    private List<ComputerVisionLogModel> computerVisionLogs;

    public UserModel() {}

    public UserModel(Long id, String name, String email, String passwordHash, LocalDateTime registrationDate, String deviceId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registrationDate = registrationDate;
        this.deviceId = deviceId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public LocalDateTime getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDateTime registrationDate) { this.registrationDate = registrationDate; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public List<AffectedAreaRegisterModel> getAffectedAreaRegisters() { return affectedAreaRegisters; }
    public void setAffectedAreaRegisters(List<AffectedAreaRegisterModel> affectedAreaRegisters) { this.affectedAreaRegisters = affectedAreaRegisters; }

    public List<LogSyncModel> getLogSyncs() { return logSyncs; }
    public void setLogSyncs(List<LogSyncModel> logSyncs) { this.logSyncs = logSyncs; }

    public List<NotificationSentModel> getNotificationsSent() { return notificationsSent; }
    public void setNotificationsSent(List<NotificationSentModel> notificationsSent) { this.notificationsSent = notificationsSent; }

    public List<SignalizationDisplayLogModel> getSignalizationDisplayLogs() { return signalizationDisplayLogs; }
    public void setSignalizationDisplayLogs(List<SignalizationDisplayLogModel> signalizationDisplayLogs) { this.signalizationDisplayLogs = signalizationDisplayLogs; }

    public List<ComputerVisionLogModel> getComputerVisionLogs() { return computerVisionLogs; }
    public void setComputerVisionLogs(List<ComputerVisionLogModel> computerVisionLogs) { this.computerVisionLogs = computerVisionLogs; }
}