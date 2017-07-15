package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Application;
import com.example.DataSource.DataSourceContextHolder;
import com.example.DataSource.DataSourceType;
import com.example.exception.MyException;
import com.example.pojo.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource2);
//		User newUser = new User();
//		newUser.setAge(5);
//		newUser.setName("kk");
//		userService.insert(newUser);
		
		User user = userService.getUserByName("AAA");
		System.out.println("...................... user age:" + user.getAge());
		Assert.assertEquals(user.getAge(), 2);
	}

}
