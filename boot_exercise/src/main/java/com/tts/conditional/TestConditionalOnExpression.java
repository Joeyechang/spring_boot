package com.tts.conditional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConditionalOnExpression("'${server.host}'=='localhost'")
public class TestConditionalOnExpression {
	public TestConditionalOnExpression(@Value("${server.host}")String host){
		super();
		System.out.println("-------------------------测试-----------------------------" + host);
	}
}
