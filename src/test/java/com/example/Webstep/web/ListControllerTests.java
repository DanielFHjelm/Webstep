package com.example.Webstep.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import com.example.Webstep.Controller.ListController;
import com.example.Webstep.Dto.ListDto;
import com.example.Webstep.Service.ListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ListController.class)
class ListControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ListService service;

	@Autowired ObjectMapper objectMapper;

	private final String listId = "5ad2ea8a-dbaf-4cd4-9515-dd47bbd4a951";

	@Test
	void getAllLists() throws Exception {
		mvc.perform(
				get("/lists")
		);
		verify(service, times(1)).getAllLists();
	}

	@Test
	void createList_ShouldSucceed() throws Exception {
		ListDto listDto = new ListDto();
		listDto.setName("test");
		String requestJson = objectMapper.writeValueAsString(listDto);

		mvc.perform(
				post("/lists")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson)
			)
				.andExpect(status().is2xxSuccessful());
		verify(service, times(1)).create(any());
	}

	@Test
	void updateList_ShouldSucceed() throws Exception {
		ListDto listDto = new ListDto();
		listDto.setId(listId);
		listDto.setName("test updated");
		String requestJson = objectMapper.writeValueAsString(listDto);

		mvc.perform(
						put("/lists/" + listId)
								.contentType(MediaType.APPLICATION_JSON)
								.content(requestJson)
				)
				.andExpect(status().is2xxSuccessful());

		verify(service, times(1)).update(any());
	}

	@Test
	void getList_ShouldSucceed() throws Exception {
		mvc.perform(
						get("/lists/" + listId)
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk());

		verify(service, times(1)).getById(any());
	}

	@Test
	void deleteList_ShouldReturnNoContent() throws Exception {
		mvc.perform(
						delete("/lists/" + listId)
				)
				.andExpect(status().isNoContent());

		verify(service, times(1)).delete(any());
	}
}
