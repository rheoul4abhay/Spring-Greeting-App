package com.spring.Spring_Greeting_App.controller;

import com.spring.Spring_Greeting_App.model.Greeting;
import com.spring.Spring_Greeting_App.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional; //to deal with non-existing id requests in database

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

    @PutMapping("/update/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id,
                                                   @RequestParam String message) {
        Greeting updatedGreeting = greetingService.updateGreetingById(id, message);
        return updatedGreeting != null ? new ResponseEntity<>(updatedGreeting, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGreetingById(@PathVariable Long id){
        boolean isDeleted = greetingService.deleteGreetingById(id);
        return isDeleted ?
                new ResponseEntity<>("Greeting deleted successfully!", HttpStatus.OK) :
                new ResponseEntity<>("Greeting not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllGreetings() {
        boolean deletedSuccessfully = greetingService.deleteAllGreetings();
        return deletedSuccessfully ?
                new ResponseEntity<>("All greetings deleted successfully!", HttpStatus.OK) :
                new ResponseEntity<>("No greeting messages found to delete", HttpStatus.NO_CONTENT);
    }
}
