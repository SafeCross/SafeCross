package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_notificacao")
public class NotificationTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_notificacao")
    private Long id;

    @Column(name = "descricao", length = 50)
    private String description;

    @OneToMany(mappedBy = "notificationType")
    private List<NotificationSentModel> notificationsSent;

    public NotificationTypeModel() {}

    public NotificationTypeModel(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<NotificationSentModel> getNotificationsSent() { return notificationsSent; }
    public void setNotificationsSent(List<NotificationSentModel> notificationsSent) { this.notificationsSent = notificationsSent; }
}