package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    private Engine engine;

//    @Autowired
//    public Car(Engine engine){
//
//        this.engine = engine;
//    }

    public void run(){
        engine.work();
    }
}
