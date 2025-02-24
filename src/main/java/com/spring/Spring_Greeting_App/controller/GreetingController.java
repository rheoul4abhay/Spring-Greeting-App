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

    @GetMapping("/personalized")
    public ResponseEntity<Greeting> getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                                            @RequestParam(required = false) String lastName){
        return new ResponseEntity<>(greetingService.getPersonalizedGreeting(firstName, lastName), HttpStatus.OK);
    }

}
