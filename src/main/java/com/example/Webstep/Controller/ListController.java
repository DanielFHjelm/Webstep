package com.example.Webstep.Controller;

import com.example.Webstep.Dto.ListDto;
import com.example.Webstep.Service.ListService;
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
@RequestMapping("/lists")
public class ListController {

  private final ListService listService;

  public ListController(ListService listService) {
    this.listService = listService;
  }

  @PostMapping
  public ListDto createList(@RequestBody ListDto list) {
    return listService.create(list);
  }

  @PutMapping("/{id}")
  public ListDto updateList(@RequestBody ListDto list){
    return listService.update(list);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteList(@PathVariable String id) {
    listService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ListDto getListById(@PathVariable String id) {
    return listService.getById(id);
  }

  @GetMapping
  public List<ListDto> getAllLists(){
    return listService.getAllLists();
  }

}
