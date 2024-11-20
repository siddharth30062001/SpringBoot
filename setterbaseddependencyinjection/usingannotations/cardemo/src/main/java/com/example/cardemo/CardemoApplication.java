package com.example.cardemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CardemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(CardemoApplication.class, args);
		Car obj= context.getBean(Car.class);
		obj.run();
	}

}
