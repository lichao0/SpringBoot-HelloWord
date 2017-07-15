package com.example;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.Application;
import com.example.dao.UserMapper;
import com.example.exception.MyException;
import com.example.pojo.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	//@Rollback(false)
	public void findByName() throws Exception {
		User user = new User();
		user.setName("BBB");
		user.setAge(10);
		user.setSex("male");
		userMapper.insertUser(user);
		
		userMapper.insert("AAA", 20);
		List<User> list = userMapper.findAll();
		for(User _user: list) {
			System.out.println(_user.getName() + _user.getAge());
		}
		
		if(true) {
			throw new MyException("tset rollback");
		}
		
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge());
	}
	
}
