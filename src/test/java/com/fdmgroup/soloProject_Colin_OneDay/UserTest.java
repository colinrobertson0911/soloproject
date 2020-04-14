package com.fdmgroup.soloProject_Colin_OneDay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.soloProject_Colin_OneDay.model.Item;
import com.fdmgroup.soloProject_Colin_OneDay.model.User;
import com.fdmgroup.soloProject_Colin_OneDay.service.ItemService;
import com.fdmgroup.soloProject_Colin_OneDay.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserTest {

	@Autowired
	UserService userService;

	@Autowired
	ItemService itemService;

	@Test
	public void test_ThatAUserCanBeCreated() {
		int numberUsersBefore = userService.findAll().size();
		User user1 = new User();
		user1.setFirstname("Jordan");
		user1.setLastname("Smith");
		userService.save(user1);
		int numberUserAfter = userService.findAll().size();
		assertNotEquals(numberUsersBefore, numberUserAfter);
	}

	@Test
	public void test_ThatAUserCanBeRetrieved() {
		User user = userService.findById(1L).get();
		assertEquals(1, user.getUserId());
	}

	@Test
	public void test_ThatAUsersBasketCanBeRetrieved() {
		User user = userService.findById(1L).get();
		List<Item> basket = itemService.findAll();
		user.getBasket();
		int numberOfItems = basket.size();
		assert (numberOfItems > 0);
	}

	@Test
	public void test_ThatAnItemCanBeBought_IfEnoughStockIsAvailable() {
		int stockBefore = itemService.findById(1L).get().getNumberInStock();
		User buyer = userService.findById(1L).get();
		userService.buyBasket(buyer);
		int stockAfter = itemService.findById(1L).get().getNumberInStock();
		assertNotEquals(stockBefore, stockAfter);

	}
	
	@Test
	public void test_ThatAnItemCannotBeBought_IfNotEnoughStockAvailable() {
		int stockBefore = itemService.findById(3L).get().getNumberInStock();
		User buyer = userService.findById(2L).get();
		userService.buyBasket(buyer);
		int stockAfter = itemService.findById(3L).get().getNumberInStock();
		assertEquals(stockBefore, stockAfter);
	}
	
	@Test 
	public void test_ThatATotalPriceCanBeCalculatedForTheBasket() {
		User user = userService.findById(1L).get();
		BigDecimal totalPriceBefore = user.getTotalPrice();
		userService.calculateTotalPrice(user);
		BigDecimal totalPriceAfter = userService.findById(1L).get().getTotalPrice();
		assertNotEquals(totalPriceBefore, totalPriceAfter);
	}

}
