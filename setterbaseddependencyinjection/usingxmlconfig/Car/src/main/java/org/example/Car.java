package org.example;

public class Car {

    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        engine.use();
        System.out.println("Car is running");
    }
}
