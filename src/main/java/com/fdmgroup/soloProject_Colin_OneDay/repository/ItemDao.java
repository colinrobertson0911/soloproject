package com.fdmgroup.soloProject_Colin_OneDay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.soloProject_Colin_OneDay.model.Item;

public interface ItemDao extends JpaRepository<Item, Long> {

	void chooseItem(String name);

}
