package com.kfit.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//拦截器
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//把自定义的拦截器加进去
		//   /api2/*/**   拦截api2下面的子路径和子路径下面的所有方法
		//   /**          拦截所有的
		//.excludePathPatterns 排除路径
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");//拦截
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
