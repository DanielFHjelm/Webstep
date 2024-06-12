package com.example.Webstep.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.example.Webstep.Domain.ListEntity;
import com.example.Webstep.Repository.ListRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ListRepositoryTests {

  @Autowired
  private ListRepository listRepository;

	@Test
	void getListWithTasks_shouldSucceed() {

		Optional<ListEntity> list = listRepository.findById("5ad2ea8a-dbaf-4cd4-9515-dd47bbd4a954");

		assertNotNull(list);
		assertEquals("4 List", list.get().getName());
		assertEquals(2, list.get().getTasks().size());
	}

	@Test
	void getListWithoutTasks_shouldSucceed() {

		Optional<ListEntity> list = listRepository.findById("5ad2ea8a-dbaf-4cd4-9515-dd47bbd4a955");

		assertNotNull(list);
		assertEquals("5 List", list.get().getName());
		assertEquals(0, list.get().getTasks().size());
	}

	@Test
	void getAllLists_shouldSucceedAndReturnSize5() {

		List<ListEntity> list = listRepository.findAll();

		assertNotNull(list);
		assertEquals(5, list.size());
	}

	@Test
	void saveList_shouldSucceed() {
		ListEntity listEntity = new ListEntity("Test List");

		ListEntity savedList = listRepository.save(listEntity);

		assertNotNull(savedList);
		assertEquals(listEntity.getName(), savedList.getName());
	}
}
