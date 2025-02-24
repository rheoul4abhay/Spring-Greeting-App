package com.spring.Spring_Greeting_App.services;

import com.spring.Spring_Greeting_App.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting getGreeting() {
        return new Greeting("Greetings from the service layer!");
    }
}
