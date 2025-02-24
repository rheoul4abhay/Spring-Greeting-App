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

    @GetMapping("/get")
    public ResponseEntity<Greeting> getGreeting() {
        return new ResponseEntity<>(greetingService.getGreeting(), HttpStatus.OK);
    }

}
