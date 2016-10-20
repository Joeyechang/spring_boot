package com.tts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopApplicationTests {
	private Log log = LogFactory.getLog(AopApplicationTests.class);
	@Test
	public void contextLoads() {
		log.info("test");
	}

}
