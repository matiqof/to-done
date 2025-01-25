package com.example.todone.task.service;

import com.example.todone.task.model.web.WebTask;

import java.util.List;

public interface TaskService {

    /**
     * Получить список всех задач
     *
     * @return список всех задач
     */
    List<WebTask> getAllTasks();

    /**
     * Получить задачу по ID
     *
     * @param id идентификатор задачи
     * @return задача
     */
    WebTask getTaskById(String id);

    /**
     * Создать новую задачу
     *
     * @param webTask задача
     * @return задача
     */
    WebTask createTask(WebTask webTask);

    /**
     * Обновить задачу
     *
     * @param webTask задача
     * @return задача
     */
    WebTask updateTask(WebTask webTask);

    /**
     * Удалить задачу
     *
     * @param id идентификатор задачи
     */
    void deleteTask(String id);
}
