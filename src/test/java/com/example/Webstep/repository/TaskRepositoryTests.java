package com.example.Webstep.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.Webstep.Domain.ListEntity;
import com.example.Webstep.Domain.TaskEntity;
import com.example.Webstep.Repository.TaskRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskRepositoryTests {
  @Autowired
  private TaskRepository taskRepository;

	@Test
	void getTask_shouldSucceed() {

		Optional<TaskEntity> task = taskRepository.findById("95e97471-dee2-4090-b734-29381a1d9b74");

		assertNotNull(task);
		assertEquals("5 Task", task.get().getName());
		assertEquals("Buy shimps", task.get().getDescription());
	}

	@Test
	void getAllTasks_shouldSucceedAndReturnSize6() {

		List<TaskEntity> task = taskRepository.findAll();

		assertNotNull(task);
		assertEquals(6, task.size());
	}

	@Test
	void saveTask_shouldSucceed() {
		TaskEntity taskEntity = new TaskEntity("Test Task", "Test Description");

		TaskEntity savedTask = taskRepository.save(taskEntity);

		assertNotNull(savedTask);
		assertEquals(taskEntity.getName(), savedTask.getName());
		assertEquals(taskEntity.getDescription(), savedTask.getDescription());
	}

}
