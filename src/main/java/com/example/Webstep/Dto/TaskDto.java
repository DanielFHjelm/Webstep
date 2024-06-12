package com.example.Webstep.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDto {
  private String id;
  private String name;
  private String description;
  private String listId;

  public TaskDto(String id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public TaskDto(String id, String name, String description, String listId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.listId = listId;
  }
}
