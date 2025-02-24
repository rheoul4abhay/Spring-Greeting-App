package com.spring.Spring_Greeting_App.controller;

import com.spring.Spring_Greeting_App.model.Greeting;
import com.spring.Spring_Greeting_App.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id){
        Optional<Greeting> greeting = greetingService.getGreetingById(id);
        return greeting.map(value -> new ResponseEntity<Greeting>(value, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings(){
        List<Greeting> greetings = greetingService.getAllGreetings();
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

}
