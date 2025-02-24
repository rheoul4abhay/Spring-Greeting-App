package com.spring.Spring_Greeting_App.controller;

import com.spring.Spring_Greeting_App.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @GetMapping("/get")
    public ResponseEntity<Greeting> getGreeting() {
        return new ResponseEntity<>(new Greeting("Greetings using GET method"), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Greeting> postGreeting(){
        return new ResponseEntity<>(new Greeting("Greetings using POST method"), HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<Greeting> putGreeting(){
        return new ResponseEntity<>(new Greeting("Greetings using PUT method"), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Greeting> deleteGreeting(){
        return new ResponseEntity<>(new Greeting("Greetings using DELETE method"), HttpStatus.OK);
    }
}
