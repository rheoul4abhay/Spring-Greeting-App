package com.spring.Spring_Greeting_App.services;

import com.spring.Spring_Greeting_App.model.Greeting;
import com.spring.Spring_Greeting_App.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    //Create greeting
    public Greeting saveGreeting(String firstName, String lastName) {
        String message = "Hello";

        if(firstName != null){
            message += " " + firstName;
        }

        if(lastName != null){
            message += " " + lastName;
        }

        if(message.trim().equalsIgnoreCase("Hello")){
            message = "Hello World";
        }

        return greetingRepository.save(new Greeting(message));
    }
}
