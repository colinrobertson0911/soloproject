package com.fdmgroup.soloProject_Coli_OneDay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.soloProject_Colin_OneDay.model.Item;
import com.fdmgroup.soloProject_Colin_OneDay.service.ItemService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ItemTest {

	@Autowired
	ItemService itemService;

	@Test
	public void test_ThatAnItemCanBeCreated() {
		Item item = new Item();
		item.setName("Bacon");
		item.setDescription("Unsmoked");
		item.setPrice(new BigDecimal("1.49"));
		int numberBeforeAdding = itemService.findAll().size();
		itemService.save(item);
		int numberAfterAdding = itemService.findAll().size();
		assertNotEquals(numberBeforeAdding, numberAfterAdding);
	}

	@Test
	public void test_ThatAnItemCanBeRetrivedUsingId() {
		Item item = itemService.findById(2L).get();
		assertEquals("Bread", item.getName());
	}

	@Test
	public void test_ThatAListOfItemsCanBeRetrieved() {
		List<Item> allItems = itemService.findAll();
		int numberOfItems = allItems.size();
		assert (numberOfItems > 0);
	}

}
