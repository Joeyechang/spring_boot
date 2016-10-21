package com.tts;

import org.apache.log4j.Logger;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AopApplicationTests {
	private Logger logger = Logger.getLogger(AopApplicationTests.class);
	@Test
	public void contextLoads() {
		logger.info("test");
        logger.error("test error");
	}

}
