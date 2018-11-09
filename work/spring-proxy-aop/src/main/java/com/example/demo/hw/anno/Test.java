package com.example.demo.hw.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("car-anno-xml.xml");

		Car car = context.getBean("car", Car.class);
		car.start();
		car.stop();

		Car luxuryCar = context.getBean("luxuryCar", Car.class);

		for (int i = 0; i < 3; i++) {
			try {
				luxuryCar.start();
			} catch (Exception e) {
			}
			luxuryCar.stop();
		}
	}

}
