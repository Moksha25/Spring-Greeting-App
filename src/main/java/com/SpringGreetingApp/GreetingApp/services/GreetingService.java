package com.SpringGreetingApp.GreetingApp.services;

import com.SpringGreetingApp.GreetingApp.model.Greeting;
import com.SpringGreetingApp.GreetingApp.model.GreetingEntity;
import com.SpringGreetingApp.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String getGreetingMessage() {
        return "Hello World!";
    }

    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public GreetingEntity updateGreeting(Long id, String newMessage) {
        Optional<GreetingEntity> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            GreetingEntity greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }

    public GreetingEntity saveGreetingMessage(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }
}
