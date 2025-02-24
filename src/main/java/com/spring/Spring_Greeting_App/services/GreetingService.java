package com.spring.Spring_Greeting_App.services;

import com.spring.Spring_Greeting_App.model.Greeting;
import com.spring.Spring_Greeting_App.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    //Create greeting message (C)
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

    //Retrive greeting message (R)
    public Optional<Greeting> getGreetingById(Long id){
        return greetingRepository.findById(id);
    }

    //Retrieve all greeting messages
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll(); //fetch all greetings from db
    }

}
