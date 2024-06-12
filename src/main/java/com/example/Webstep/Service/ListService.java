package com.example.Webstep.Service;

import com.example.Webstep.Domain.ListEntity;
import com.example.Webstep.Dto.ListDto;
import com.example.Webstep.Mapper.ListMapper;
import com.example.Webstep.Repository.ListRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListService {

  private final ListRepository listRepository;
  private final ListMapper listMapper;

  public ListService(ListRepository listRepository, ListMapper listMapper){
    this.listRepository = listRepository;
    this.listMapper = listMapper;
  }

  public ListDto create(ListDto listDto) {
    return listMapper.toDto(
        listRepository.save(listMapper.toEntity(listDto)));
  }

  public ListDto update(ListDto listDto) {
    ListEntity list = listRepository.findById(listDto.getId()).orElse(null);
    if (list != null) {
      list.setName(listDto.getName());
      return listMapper.toDto(
          listRepository.save(list));
    }
    return listMapper.toDto(
        listRepository.save(listMapper.toEntity(listDto)));
  }

  public void delete(String id) {
        listRepository.deleteById(id);
  }

  public ListDto getById(String id) {
    return listMapper.toDto(
        listRepository.findById(id).orElse(null)
    );
  }

  public List<ListDto> getAllLists() {
    return listMapper.toDtos(listRepository.findAll());
  }
}
