package com.example.todone.task.mapper;

import com.example.todone.task.model.Task;
import com.example.todone.task.model.web.WebTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    WebTask map(Task source);

    List<WebTask> map(List<Task> source);

    @Mapping(target = "created_at", ignore = true)
    @Mapping(target = "updated_at", ignore = true)
    Task map(WebTask source);
}
