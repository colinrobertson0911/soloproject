package com.fdmgroup.soloProject_Colin_OneDay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.soloProject_Colin_OneDay.model.User;

public interface UserDao extends JpaRepository<User, Long>{

}
