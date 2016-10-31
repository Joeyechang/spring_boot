package com.tts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
	final static Logger logger = LoggerFactory.getLogger(Log4jTest.class);
	final static Log log = LogFactory.getLog(Log4jTest.class);
	@Test
	public void test(){
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
	}

}
