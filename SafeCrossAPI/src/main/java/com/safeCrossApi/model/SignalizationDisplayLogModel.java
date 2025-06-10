package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_sinalizacao_exibida")
public class SignalizationDisplayLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "id_semaforo", nullable = false)
    private ModeledSemaphoreModel semaphore;

    @Column(name = "data_hora_exibicao")
    private LocalDateTime displayDateTime;

    @ManyToOne
    @JoinColumn(name = "id_tipo_visualizacao", nullable = false)
    private VisualizationTypeModel visualizationType;

    public SignalizationDisplayLogModel() {}

    public SignalizationDisplayLogModel(Long id, UserModel user, ModeledSemaphoreModel semaphore, LocalDateTime displayDateTime, VisualizationTypeModel visualizationType) {
        this.id = id;
        this.user = user;
        this.semaphore = semaphore;
        this.displayDateTime = displayDateTime;
        this.visualizationType = visualizationType;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserModel getUser() { return user; }
    public void setUser(UserModel user) { this.user = user; }

    public ModeledSemaphoreModel getSemaphore() { return semaphore; }
    public void setSemaphore(ModeledSemaphoreModel semaphore) { this.semaphore = semaphore; }

    public LocalDateTime getDisplayDateTime() { return displayDateTime; }
    public void setDisplayDateTime(LocalDateTime displayDateTime) { this.displayDateTime = displayDateTime; }

    public VisualizationTypeModel getVisualizationType() { return visualizationType; }
    public void setVisualizationType(VisualizationTypeModel visualizationType) { this.visualizationType = visualizationType; }
}