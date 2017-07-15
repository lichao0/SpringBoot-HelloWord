package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.exception.MyException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LogBackTests {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() throws Exception {
		try {
			throw new MyException("test log");
		} catch(Exception e) {
			logger.error("aaa", e);
		}
		logger.debug("输出debug");
		logger.info("输出info");
		logger.warn("输出warn");
		logger.error("输出error");
	}

}
