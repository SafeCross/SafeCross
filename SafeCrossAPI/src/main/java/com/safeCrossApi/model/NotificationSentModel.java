package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificacao_enviada")
public class NotificationSentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "id_tipo_notificacao", nullable = false)
    private NotificationTypeModel notificationType;

    @Column(name = "data_hora_envio")
    private LocalDateTime sentDateTime;

    @Column(name = "latitude_alvo", precision = 10, scale = 8)
    private String targetLatitude;

    @Column(name = "longitude_alvo", precision = 11, scale = 8)
    private String targetLongitude;

    public NotificationSentModel() {}

    public NotificationSentModel(Long id, UserModel user, NotificationTypeModel notificationType, LocalDateTime sentDateTime, String targetLatitude, String targetLongitude) {
        this.id = id;
        this.user = user;
        this.notificationType = notificationType;
        this.sentDateTime = sentDateTime;
        this.targetLatitude = targetLatitude;
        this.targetLongitude = targetLongitude;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserModel getUser() { return user; }
    public void setUser(UserModel user) { this.user = user; }

    public NotificationTypeModel getNotificationType() { return notificationType; }
    public void setNotificationType(NotificationTypeModel notificationType) { this.notificationType = notificationType; }

    public LocalDateTime getSentDateTime() { return sentDateTime; }
    public void setSentDateTime(LocalDateTime sentDateTime) { this.sentDateTime = sentDateTime; }

    public String getTargetLatitude() { return targetLatitude; }
    public void setTargetLatitude(String targetLatitude) { this.targetLatitude = targetLatitude; }

    public String getTargetLongitude() { return targetLongitude; }
    public void setTargetLongitude(String targetLongitude) { this.targetLongitude = targetLongitude; }
}