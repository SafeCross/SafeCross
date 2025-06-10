package com.safeCrossApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para cadastro de tipo de notificação")
public class NotificationTypeRequestDTO {

    @Schema(description = "Descrição do tipo de notificação", example = "Área afetada próxima")
    private String description;

    public NotificationTypeRequestDTO() {}

    public NotificationTypeRequestDTO(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}