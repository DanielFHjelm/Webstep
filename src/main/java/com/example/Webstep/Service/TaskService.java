package com.example.Webstep.Service;

import com.example.Webstep.Domain.ListEntity;
import com.example.Webstep.Domain.TaskEntity;
import com.example.Webstep.Dto.TaskDto;
import com.example.Webstep.Mapper.TaskMapper;
import com.example.Webstep.Repository.ListRepository;
import com.example.Webstep.Repository.TaskRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private final TaskRepository taskRepository;
  private final TaskMapper taskMapper;
  private final ListRepository listRepository;

  public TaskService(TaskRepository taskRepository, TaskMapper taskMapper,
      ListRepository listRepository){
    this.taskRepository = taskRepository;
    this.taskMapper = taskMapper;
    this.listRepository = listRepository;
  }

  public TaskDto create(TaskDto taskDto) {
    return taskMapper.toDto(
          taskRepository.save(taskMapper.toEntity(taskDto)));
  }

  public TaskDto update(TaskDto taskDto) {
    TaskEntity task = taskRepository.findById(taskDto.getId()).orElse(null);
    if (task != null) {
      task.setName(taskDto.getName());
      task.setDescription(taskDto.getDescription());
      return taskMapper.toDto(
          taskRepository.save(task));
    }
    return taskMapper.toDto(
        taskRepository.save(taskMapper.toEntity(taskDto)));
  }

  public void delete(String id) {
    taskRepository.deleteById(id);
  }

  public TaskDto getById(String id) {
    return taskMapper.toDto(
        taskRepository.findById(id).orElse(null)
    );
  }

  public List<TaskDto> getAllTasks() {
    return taskMapper.toDtos(taskRepository.findAll());
  }

  public TaskDto addToList(String listId, TaskDto taskDto) {
    ListEntity listEntity = listRepository.findById(listId).orElse(null);
    TaskEntity taskEntity = taskRepository.findById(taskDto.getId()).orElse(null);
    if (listEntity != null && taskEntity != null) {
      taskEntity.setList(listEntity);
      return taskMapper.toDto(taskRepository.save(taskEntity));
    }
    return null;
  }

}
