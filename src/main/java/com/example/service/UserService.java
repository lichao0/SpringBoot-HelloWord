package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserMapper;
import com.example.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByName(String username) {
		User user = userMapper.findByName(username);
		return user;
	}
	
	@Transactional
	public int insert(User user) {
		int rs = userMapper.insertUser(user);
		User user2 = getUserByName("kk");
		System.out.println(user2.getName());
		int i = 1/0;
		return rs;
	}
	
}
