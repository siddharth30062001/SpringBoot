package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppCofig.class);
        Car c= (Car)context.getBean(Car.class);
        c.run();

    }
}
