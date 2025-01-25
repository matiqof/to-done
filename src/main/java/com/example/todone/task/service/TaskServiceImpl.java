package com.example.todone.task.service;

import com.example.todone.task.mapper.TaskMapper;
import com.example.todone.task.model.Task;
import com.example.todone.task.model.web.WebTask;
import com.example.todone.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<WebTask> getAllTasks() {
        try {
            return taskMapper.map(taskRepository.findAll());
        } catch (Exception e) {
            log.error("Ошибка получения списка задач: ", e);
        }

        return Collections.emptyList();
    }

    @Override
    public WebTask getTaskById(String id) {
        try {
            return taskMapper.map(taskRepository.getTaskById(UUID.fromString(id)));
        } catch (Exception e) {
            log.error("Ошибка получения задачи по ID: ", e);
        }

        return WebTask.builder().build();
    }

    @Override
    public WebTask createTask(WebTask webTask) {
        try {
            return taskMapper.map(taskRepository.save(taskMapper.map(webTask)));
        } catch (Exception e) {
            log.error("Ошибка получения задачи по ID: ", e);
        }

        return WebTask.builder().build();
    }

    @Override
    public WebTask updateTask(WebTask webTask) {
        Optional<Task> optionalTask = taskRepository.findById(UUID.fromString(webTask.getId()));
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();

            if (Objects.nonNull(webTask.getTitle())) {
                task.setTitle(webTask.getTitle());
            }
            if (Objects.nonNull(webTask.getDescription())) {
                task.setDescription(webTask.getDescription());
            }
            if (Objects.nonNull(webTask.getDueDate())) {
                task.setDueDate(webTask.getDueDate());
            }
            if (Objects.nonNull(webTask.getCompleted())) {
                task.setCompleted(webTask.getCompleted());
            }

            return taskMapper.map(taskRepository.save(task));
        }

        return WebTask.builder().build();
    }

    @Override
    public void deleteTask(String id) {
        try {
            UUID taskId = UUID.fromString(id);
            if (taskRepository.existsTaskById(taskId)) {
                taskRepository.deleteById(taskId);
            }
        } catch (Exception e) {
            log.error("Ошибка удаления задачи по ID: ", e);
        }
    }
}
