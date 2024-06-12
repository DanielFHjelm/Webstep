package com.example.Webstep.Mapper;

import com.example.Webstep.Domain.TaskEntity;
import com.example.Webstep.Dto.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements DtoMapper<TaskDto, TaskEntity>{

  public TaskDto toDto(TaskEntity taskEntity) {
    if(taskEntity.getList() != null) {
      return new TaskDto(taskEntity.getId(), taskEntity.getName(), taskEntity.getDescription(),
          taskEntity.getList().getId());
    }
    return new TaskDto(taskEntity.getId(), taskEntity.getName(), taskEntity.getDescription());
  }

  public TaskEntity toEntity(TaskDto taskDto) {
    return new TaskEntity(taskDto.getName(), taskDto.getDescription());
  }
}
