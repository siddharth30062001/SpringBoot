package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
 class App
{
    public static void main( String[] args )
    {

        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        Car obj= context.getBean(Car.class);
        obj.run();

    }
}
