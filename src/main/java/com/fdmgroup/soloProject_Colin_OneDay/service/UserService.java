package com.fdmgroup.soloProject_Colin_OneDay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.soloProject_Colin_OneDay.model.User;
import com.fdmgroup.soloProject_Colin_OneDay.repository.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void save(User user) {
		userDao.save(user);
	}

	public Optional<User> findById(long userId) {
		return userDao.findById(userId);
	}
}
