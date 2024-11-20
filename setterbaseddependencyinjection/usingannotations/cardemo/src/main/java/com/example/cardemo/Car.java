package com.example.cardemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine eng;

    @Autowired
    public void setEng(Engine eng) {
        this.eng = eng;
    }

    public void run(){

        eng.use();
    }
}
