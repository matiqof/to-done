package com.example.todone.task.controller;

import com.example.todone.task.model.web.WebTask;
import com.example.todone.task.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    @Operation(summary = "Получить список всех задач")
    public List<WebTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить задачу по ID")
    public WebTask getTaskById(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    @Operation(summary = "Создать новую задачу")
    public WebTask createTask(
            @Parameter(description = "Данные задачи", required = true)
            @RequestBody WebTask webTask) {
        return taskService.createTask(webTask);
    }

    @PutMapping
    @Operation(summary = "Обновить задачу")
    public WebTask updateTask(
            @Parameter(description = "Обновленные данные задачи", required = true)
            @RequestBody WebTask webTask) {
        return taskService.updateTask(webTask);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить задачу")
    public void deleteTask(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable String id) {
        taskService.deleteTask(id);
    }
}
