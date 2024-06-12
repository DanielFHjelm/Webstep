package com.example.Webstep.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.Webstep.Controller.TaskController;
import com.example.Webstep.Dto.TaskDto;
import com.example.Webstep.Service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
class TaskControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TaskService service;

	@Autowired ObjectMapper objectMapper;

	private final String taskId = "95e97471-dee2-4090-b734-29381a1d9b70";

	@Test
	void getAllTasks() throws Exception {
		mvc.perform(
				get("/tasks")
		);
		verify(service, times(1)).getAllTasks();
	}

	@Test
	void createTask_ShouldSucceed() throws Exception {
		TaskDto taskDto = new TaskDto();
		taskDto.setName("test");
		String requestJson = objectMapper.writeValueAsString(taskDto);

		mvc.perform(
				post("/tasks")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson)
			)
				.andExpect(status().is2xxSuccessful());
		verify(service, times(1)).create(any());
	}

	@Test
	void updateTask_ShouldSucceed() throws Exception {
		TaskDto taskDto = new TaskDto();
		taskDto.setId(taskId);
		taskDto.setName("test updated");
		String requestJson = objectMapper.writeValueAsString(taskDto);

		mvc.perform(
						put("/tasks/" + taskId)
								.contentType(MediaType.APPLICATION_JSON)
								.content(requestJson)
				)
				.andExpect(status().is2xxSuccessful());
		verify(service, times(1)).update(any());
	}

	@Test
	void getTask_ShouldSucceed() throws Exception {
		mvc.perform(
						get("/tasks/" + taskId)
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk());

		verify(service, times(1)).getById(any());
	}

	@Test
	void deleteTask_ShouldReturnNoContent() throws Exception {
		mvc.perform(
						delete("/tasks/" + taskId)
				)
				.andExpect(status().isNoContent());

		verify(service, times(1)).delete(any());
	}

}
