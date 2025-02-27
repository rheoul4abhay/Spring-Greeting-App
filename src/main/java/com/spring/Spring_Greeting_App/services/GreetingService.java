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

    //Update greeting message (U)
    public Greeting updateGreetingById(Long id, String newMessage){
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);

        if(existingGreeting.isPresent()){
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage); //update message
            return greetingRepository.save(greeting); //save updated greeting
        }
        return null; //if id is not found in db
    }

    //Delete greeting by id (D)
    public boolean deleteGreetingById(Long id){
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);

        if(existingGreeting.isPresent()){
            greetingRepository.deleteById(id);
            return true;
        }
        return false; //if id is not found in db
    }

    //Optional feature - Delete all greeting messages from db
    public boolean deleteAllGreetings() {
        if(greetingRepository.count() > 0) {
            greetingRepository.deleteAll();
            return true;
        }
        return false;
    }

}
