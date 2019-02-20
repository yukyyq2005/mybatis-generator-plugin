package com.kfit.domain;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExtHandler {
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	Object handleException(Exception e, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 100);
		map.put("msg", e.getMessage());
		map.put("url", request.getRequestURL());
		return map;
	}

}
