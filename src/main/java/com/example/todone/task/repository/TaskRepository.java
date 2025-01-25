package com.example.todone.task.repository;

import com.example.todone.task.model.Task;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    /**
     * Получить задачу по ID
     *
     * @param id идентификатор задачи
     * @return задача
     */
    Task getTaskById(UUID id);

    /**
     * Проверить существование задачи по идентификатору
     *
     * @param id идентификатор задачи
     * @return true/false в зависимости от условия
     */
    boolean existsTaskById(UUID id);

    /**
     * Удалить задачу по идентификатору
     *
     * @param id идентификатор задачи
     */
    void deleteById(@NonNull UUID id);
}