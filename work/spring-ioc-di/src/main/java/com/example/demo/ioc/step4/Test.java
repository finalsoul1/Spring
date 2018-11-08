package com.example.demo.ioc.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		CarMaker maker = new KiaMaker(); // 객체생성
//		CarMaker maker = new HyundaiMaker(); // 객체생성
//		
//		OrderManager manager = new OrderManager(); // 객체생성
//		manager.setMaker(maker); // 관계설정
//		manager.order(); // 로직호출
		
		/*
		 * 스프링에게 객체생성, 관계설정을 위임하는 방법 3가지
		 * 1. XML
		 * 2. Annotation
		 * 3. Java Configuration Class
		 */
		
		// 1.
		ApplicationContext context = new ClassPathXmlApplicationContext("car-config.xml");
		
		// 스프링이 보관하는 객체를 빈이라고 부름 => id가 manager인 객체를 불러와
		OrderManager manager = (OrderManager) context.getBean("manager");
		manager.order();
	}
}
