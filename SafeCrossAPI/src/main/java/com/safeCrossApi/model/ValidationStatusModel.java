package com.safeCrossApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "status_validacao")
public class ValidationStatusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_validacao")
    private Long id;

    @Column(name = "descricao", length = 50)
    private String description;

    @OneToMany(mappedBy = "validationStatus")
    private List<AffectedAreaRegisterModel> affectedAreaRegisters;

    public ValidationStatusModel() {}

    public ValidationStatusModel(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<AffectedAreaRegisterModel> getAffectedAreaRegisters() { return affectedAreaRegisters; }
    public void setAffectedAreaRegisters(List<AffectedAreaRegisterModel> affectedAreaRegisters) { this.affectedAreaRegisters = affectedAreaRegisters; }
}