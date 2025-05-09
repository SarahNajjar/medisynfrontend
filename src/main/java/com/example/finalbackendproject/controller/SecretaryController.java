package com.example.finalbackendproject.controller;

import com.example.finalbackendproject.model.Secretary;
import com.example.finalbackendproject.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secretaries")
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    @GetMapping
    public List<Secretary> getAllSecretaries() {
        return secretaryService.getAllSecretaries();
    }

    @GetMapping("/{username}")
    public Secretary getSecretaryByUsername(@PathVariable String username) {
        return secretaryService.getSecretaryByUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Secretary saveSecretary(@RequestBody Secretary secretary) {
        return secretaryService.saveSecretary(secretary);
    }

    @PutMapping("/{username}")
    public Secretary updateSecretary(@PathVariable String username, @RequestBody Secretary secretary) {
        secretary.setUsername(username);
        return secretaryService.saveSecretary(secretary);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSecretary(@PathVariable String username) {
        secretaryService.deleteSecretary(username);
    }

    @PostMapping("/login")
    public boolean authenticateSecretary(@RequestParam String username, @RequestParam String password) {
        return secretaryService.authenticateSecretary(username, password);
    }
}
