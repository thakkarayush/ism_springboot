package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class SessionController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(UserBean user) {
		System.out.println("First Name:"+user.getFirstName());
		System.out.println("Last Name:"+user.getLastName());
		userDao.saveAllUser(user);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/getusers")
	public ResponseEntity<?> getAllUser(){
		System.out.println("Get All User");
		List<UserBean> user_values=userDao.getAllUser();
		return ResponseEntity.ok(user_values);
	}
}
