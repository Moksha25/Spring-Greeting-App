package com.SpringGreetingApp.GreetingApp.controller;

import com.SpringGreetingApp.GreetingApp.model.Greeting;
import com.SpringGreetingApp.GreetingApp.model.UserDTO;
import com.SpringGreetingApp.GreetingApp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<Greeting> getGreeting() {
        return ResponseEntity.ok(new Greeting(greetingService.getGreetingMessage()));
    }

    @PostMapping("/greeting")
    public ResponseEntity<Greeting> createGreeting(@RequestBody UserDTO user) {
        String message = generateGreetingMessage(user.getFirstName(), user.getLastName());
        return ResponseEntity.status(201).body(new Greeting(message));
    }

    @PutMapping("/greeting")
    public ResponseEntity<Greeting> updateGreeting(@RequestBody UserDTO user) {
        String message = "Updated greeting: " + generateGreetingMessage(user.getFirstName(), user.getLastName());
        return ResponseEntity.ok(new Greeting(message));
    }

    @DeleteMapping("/greeting")
    public ResponseEntity<Greeting> deleteGreeting() {
        return ResponseEntity.ok(new Greeting("Greeting deleted successfully."));
    }

    private String generateGreetingMessage(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello " + firstName + " " + lastName + " from BridgeLabz!";
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello " + firstName + " from BridgeLabz!";
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello " + lastName + " from BridgeLabz!";
        } else {
            return "Hello World!";
        }
    }
}

