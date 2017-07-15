package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserMapper;
import com.example.exception.MyException;
import com.example.pojo.User;


@RestController
public class HelloController {
	
	final static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Value("${helloStr}")
	private String str;
	
	@Autowired
	private User userInfo;
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() throws MyException {
		for(int i=0; i<1000; i++) {
			Byte[] bytes = new Byte[1024000];
			System.out.println(bytes);
		}
		//throw new MyException("发生异常");
		System.out.println(userMapper.findAll());
		return str + userInfo.getAge();
	}

}
