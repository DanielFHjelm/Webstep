package com.example.Webstep.Dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListDto {
  private String id;
  private String name;
  private List<TaskDto> tasks;

  public ListDto(String id, String name, List<TaskDto> tasks) {
    this.id = id;
    this.name = name;
    this.tasks = tasks;
  }

  public ListDto(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
