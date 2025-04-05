package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.model.User;
import com.spring.project.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<User> findaAll() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public void save(@RequestBody User user) {
        userService.createUser(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}")
    public void update(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }
}