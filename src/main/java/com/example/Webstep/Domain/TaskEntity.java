package com.example.Webstep.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

  public TaskEntity(String name, String description) {
    id = UUID.randomUUID().toString();
    this.name = name;
    this.description = description;
  }

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="list_id", referencedColumnName="list_id")
  private ListEntity list;

  @Id
  @Column(length = 36)
  private String id;

  @Column(length = 256)
  private String name;

  @Column(length = 1024)
  private String description;
}
