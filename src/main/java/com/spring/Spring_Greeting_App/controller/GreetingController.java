package com.spring.Spring_Greeting_App.controller;

import com.spring.Spring_Greeting_App.model.Greeting;
import com.spring.Spring_Greeting_App.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @PostMapping("/save")
    public ResponseEntity<Greeting> saveGreeting(@RequestParam(required = false) String firstName,
                                                 @RequestParam(required = false) String lastName){
        return new ResponseEntity<>(greetingService.saveGreeting(firstName, lastName), HttpStatus.CREATED);
    }

}
