package com.fdmgroup.soloProject_Colin_OneDay.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.soloProject_Colin_OneDay.model.Item;
import com.fdmgroup.soloProject_Colin_OneDay.model.User;
import com.fdmgroup.soloProject_Colin_OneDay.repository.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ItemService itemService;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void save(User user) {
		userDao.save(user);
	}

	public Optional<User> findById(long userId) {
		return userDao.findById(userId);
	}

	public void buyBasket(User user) {
		boolean purchase = true;
		for(Item item : user.getBasket()) {
			if(item.getNumberInStock() == 0) {
				purchase = false;
			}
		}
		if (purchase) {
			for (Item item : user.getBasket()) {
				item.setNumberInStock(item.getNumberInStock() - 1);
				itemService.save(item);
			}

			user.getBasket().clear();
			user.setTotalPrice(new BigDecimal("0.00"));
		}
		save(user);

	}

	public void calculateTotalPrice(User user) {
		BigDecimal totalPrice = new BigDecimal("0.00");
		for (Item item : user.getBasket()) {
			totalPrice = totalPrice.add(item.getPrice());
		}
		 user.setTotalPrice(totalPrice);
		 save(user);
	}
		

}
