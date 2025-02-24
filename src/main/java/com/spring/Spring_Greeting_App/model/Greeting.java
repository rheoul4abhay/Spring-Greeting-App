package com.spring.Spring_Greeting_App.model;

import jakarta.persistence.Entity;

public class Greeting {
    private String message;

    public Greeting(){};

    public Greeting(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
