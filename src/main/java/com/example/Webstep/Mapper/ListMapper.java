package com.example.Webstep.Mapper;

import com.example.Webstep.Domain.ListEntity;
import com.example.Webstep.Dto.ListDto;
import org.springframework.stereotype.Component;

@Component
public class ListMapper implements DtoMapper<ListDto, ListEntity>{

  private final TaskMapper taskMapper;

  public ListMapper(TaskMapper taskMapper) {
    this.taskMapper = taskMapper;
  }

  public ListDto toDto(ListEntity listEntity) {
    if (listEntity.getTasks() != null) {
      return new ListDto(listEntity.getId(), listEntity.getName(),
          taskMapper.toDtos(listEntity.getTasks()));
    }
    return new ListDto(listEntity.getId(), listEntity.getName());
  }

  public ListEntity toEntity(ListDto listDto) {
    if (listDto.getTasks() != null) {
      return new ListEntity(listDto.getName(), taskMapper.toEntities(listDto.getTasks()));
    }
    return new ListEntity(listDto.getName());
  }

}
