package com.kfit.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//监听器

//@WebListener

//继承ServletContextListener可以做资源的初始化，最好开启线程来处理
//继承ServletRequestListener主要做http请求的统计
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed");
	}
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized1");
	}
}
