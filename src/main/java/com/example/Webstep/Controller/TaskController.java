package com.example.Webstep.Controller;

import com.example.Webstep.Dto.ListDto;
import com.example.Webstep.Dto.TaskDto;
import com.example.Webstep.Service.TaskService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping
  public TaskDto createTask(@RequestBody TaskDto task) {
    return taskService.create(task);
  }

  @PutMapping("/{id}")
  public TaskDto updateTask(@RequestBody TaskDto task){
    return taskService.update(task);
  }

  @PutMapping("/list/{listId}")
  public TaskDto addTaskToList(@PathVariable String listId, @RequestBody TaskDto task){
    return taskService.addToList(listId, task);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable String id) {
    taskService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public TaskDto getTaskById(@PathVariable String id) {
    return taskService.getById(id);
  }

  @GetMapping
  public List<TaskDto> getAllTasks(){
    return taskService.getAllTasks();
  }
}
