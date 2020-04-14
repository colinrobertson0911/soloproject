package com.fdmgroup.soloProject_Colin_OneDay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.soloProject_Colin_OneDay.model.Item;
import com.fdmgroup.soloProject_Colin_OneDay.repository.ItemDao;

@Service
public class ItemService {

	@Autowired
	ItemDao itemDao;

	public List<Item> findAll() {
		return itemDao.findAll();
	}

	public void save(Item item) {
		itemDao.save(item);
	}

	public Optional<Item> findById(long itemId) {
		return itemDao.findById(itemId);
	}

}
