package com.example;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Log4jTests {
	
	private Logger logger = Logger.getLogger(getClass());
			
	@Test
	public void test() {
		logger.debug("输出debug");
		logger.info("输出info");
		logger.warn("输出warn");
		logger.error("输出error");
	}

}
