package com.example.Webstep.Mapper;

import java.util.List;

public interface DtoMapper<DTO, ENTITY> {

  DTO toDto(ENTITY entity);

  default List<DTO> toDtos(List<ENTITY> entities) {
    return entities.stream().map(this::toDto).toList();
  }

  ENTITY toEntity(DTO dto);

  default List<ENTITY> toEntities(List<DTO> entities) {
    return entities.stream().map(this::toEntity).toList();
  }
}
