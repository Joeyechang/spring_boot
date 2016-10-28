package com.tts.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	final static Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	/*@ExceptionHandler({SQLException.class})
	public String databaseError() {

		return "databaseError";
	}
*/
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception ex) throws Exception {
		logger.error("request: {}", req.getRequestURI());
		if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
			throw ex;

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
	
}
