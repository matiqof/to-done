package com.example.todone.task.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column()
    private UUID id;

    /**
     * Название задачи
     */
    @Column
    private String title;

    /**
     * Описание задачи
     */
    @Column
    private String description;

    /**
     * Дата выполнения задачи
     */
    @Column
    private OffsetDateTime dueDate;

    /**
     * Статус выполнения задачи
     */
    @Column
    private boolean completed;

    /**
     * Дата и время создания записи
     */
    @CreationTimestamp
    private OffsetDateTime created_at;

    /**
     * Дата и время обновления записи
     */
    @UpdateTimestamp
    private OffsetDateTime updated_at;
}
