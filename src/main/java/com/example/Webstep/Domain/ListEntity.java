package com.example.Webstep.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListEntity {

  public ListEntity(String name) {
    id = UUID.randomUUID().toString();
    this.name = name;
  }

  public ListEntity(String name, List<TaskEntity> tasks) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.tasks = tasks;
  }

  @Id
  @Column(length = 36, name = "list_id")
  private String id;

  @Column(length = 256)
  private String name;

  @OneToMany(mappedBy="list", fetch = FetchType.EAGER)
  private List<TaskEntity> tasks;
}
