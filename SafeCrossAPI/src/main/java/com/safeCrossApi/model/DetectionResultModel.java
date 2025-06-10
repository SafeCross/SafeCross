package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "resultado_deteccao")
public class DetectionResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado_deteccao")
    private Long id;

    @Column(name = "descricao", length = 50)
    private String description;

    @OneToMany(mappedBy = "detectionResult")
    private List<ComputerVisionLogModel> computerVisionLogs;

    public DetectionResultModel() {}

    public DetectionResultModel(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<ComputerVisionLogModel> getComputerVisionLogs() { return computerVisionLogs; }
    public void setComputerVisionLogs(List<ComputerVisionLogModel> computerVisionLogs) { this.computerVisionLogs = computerVisionLogs; }
}
