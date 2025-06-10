package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_visual_computacional")
public class ComputerVisionLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_vc")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "id_semaforo", nullable = false)
    private ModeledSemaphoreModel semaphore;

    @Column(name = "data_hora_utilizacao")
    private LocalDateTime usageDateTime;

    @ManyToOne
    @JoinColumn(name = "id_resultado_deteccao", nullable = false)
    private DetectionResultModel detectionResult;

    public ComputerVisionLogModel() {}

    public ComputerVisionLogModel(Long id, UserModel user, ModeledSemaphoreModel semaphore, LocalDateTime usageDateTime, DetectionResultModel detectionResult) {
        this.id = id;
        this.user = user;
        this.semaphore = semaphore;
        this.usageDateTime = usageDateTime;
        this.detectionResult = detectionResult;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserModel getUser() { return user; }
    public void setUser(UserModel user) { this.user = user; }

    public ModeledSemaphoreModel getSemaphore() { return semaphore; }
    public void setSemaphore(ModeledSemaphoreModel semaphore) { this.semaphore = semaphore; }

    public LocalDateTime getUsageDateTime() { return usageDateTime; }
    public void setUsageDateTime(LocalDateTime usageDateTime) { this.usageDateTime = usageDateTime; }

    public DetectionResultModel getDetectionResult() { return detectionResult; }
    public void setDetectionResult(DetectionResultModel detectionResult) { this.detectionResult = detectionResult; }
}