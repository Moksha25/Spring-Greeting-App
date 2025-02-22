package com.SpringGreetingApp.GreetingApp.controller;

import com.SpringGreetingApp.GreetingApp.model.Greeting;
import com.SpringGreetingApp.GreetingApp.model.UserDTO;
import com.SpringGreetingApp.GreetingApp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting getGreeting() {
        String message = greetingService.getGreetingMessage();
        return new Greeting(message);
    }

    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestBody UserDTO user) {
        return new Greeting("Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz!");
    }

    @PutMapping("/greeting")
    public Greeting updateGreeting(@RequestBody UserDTO user) {
        return new Greeting("Updated greeting for " + user.getFirstName() + " " + user.getLastName());
    }

    @DeleteMapping("/greeting")
    public Greeting deleteGreeting() {
        return new Greeting("Greeting deleted successfully.");
    }
}