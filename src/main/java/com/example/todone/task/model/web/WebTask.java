package com.example.todone.task.model.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель задачи")
public class WebTask {

    @Schema(description = "Уникальный идентификатор задачи", example = "1")
    private String id;

    @Schema(description = "Название задачи", example = "Купить продукты")
    private String title;

    @Schema(description = "Описание задачи", example = "Молоко, хлеб, яйца")
    private String description;

    @Schema(description = "Дата выполнения задачи", example = "2023-12-01T18:00:00")
    private OffsetDateTime dueDate;

    @Schema(description = "Статус выполнения задачи", example = "false")
    private Boolean completed;
}