package com.safeCrossApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta do tipo de notificação")
public class NotificationTypeResponseDTO {

    @Schema(description = "ID do tipo de notificação", example = "1")
    private Long id;

    @Schema(description = "Descrição do tipo de notificação", example = "Área afetada próxima")
    private String description;

    public NotificationTypeResponseDTO() {}

    public NotificationTypeResponseDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}