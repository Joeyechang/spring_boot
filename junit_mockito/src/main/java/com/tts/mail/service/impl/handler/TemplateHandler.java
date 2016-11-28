package com.tts.mail.service.impl.handler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class TemplateHandler {

	@Autowired
	FreeMarkerConfigurer freeMarkerConfigurer;

	public String getStringByTemplate(String name, List<?> dataList) throws IOException, TemplateException {
		Template template = freeMarkerConfigurer.getConfiguration().getTemplate(name);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("dataList", dataList);
		StringWriter writer = new StringWriter();
		template.process(model, writer);
		return writer.toString();
	}
}
