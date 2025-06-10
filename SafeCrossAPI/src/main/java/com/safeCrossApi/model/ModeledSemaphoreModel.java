package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "semaforo_modelado")
public class ModeledSemaphoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semaforo")
    private Long id;

    @Column(name = "latitude", precision = 10, scale = 8)
    private String latitude;

    @Column(name = "longitude", precision = 11, scale = 8)
    private String longitude;

    @Column(name = "descricao_localizacao", length = 255)
    private String locationDescription;

    @Column(name = "tempo_verde")
    private Integer greenTime;

    @Column(name = "tempo_amarelo")
    private Integer yellowTime;

    @Column(name = "tempo_vermelho")
    private Integer redTime;

    @Column(name = "ultima_atualizacao")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "semaphore")
    private List<SignalizationDisplayLogModel> signalizationDisplayLogs;

    @OneToMany(mappedBy = "semaphore")
    private List<ComputerVisionLogModel> computerVisionLogs;

    public ModeledSemaphoreModel() {}

    public ModeledSemaphoreModel(Long id, String latitude, String longitude, String locationDescription, Integer greenTime, Integer yellowTime, Integer redTime, LocalDateTime lastUpdate) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDescription = locationDescription;
        this.greenTime = greenTime;
        this.yellowTime = yellowTime;
        this.redTime = redTime;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public String getLocationDescription() { return locationDescription; }
    public void setLocationDescription(String locationDescription) { this.locationDescription = locationDescription; }

    public Integer getGreenTime() { return greenTime; }
    public void setGreenTime(Integer greenTime) { this.greenTime = greenTime; }

    public Integer getYellowTime() { return yellowTime; }
    public void setYellowTime(Integer yellowTime) { this.yellowTime = yellowTime; }

    public Integer getRedTime() { return redTime; }
    public void setRedTime(Integer redTime) { this.redTime = redTime; }

    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }

    public List<SignalizationDisplayLogModel> getSignalizationDisplayLogs() { return signalizationDisplayLogs; }
    public void setSignalizationDisplayLogs(List<SignalizationDisplayLogModel> signalizationDisplayLogs) { this.signalizationDisplayLogs = signalizationDisplayLogs; }

    public List<ComputerVisionLogModel> getComputerVisionLogs() { return computerVisionLogs; }
    public void setComputerVisionLogs(List<ComputerVisionLogModel> computerVisionLogs) { this.computerVisionLogs = computerVisionLogs; }
}