package org.example;

public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        engine.use();
        System.out.println("Car is running");
    }
}
