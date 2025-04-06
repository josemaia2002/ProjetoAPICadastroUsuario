package com.spring.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.model.User;
import com.spring.project.model.UserNotFoundException;
import com.spring.project.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id); 

        if(user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return user.get();
    }

    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email); 

        if(user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return user.get();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user, Long id) {
        User updatedUser = findUserById(id);
        
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setBirthday(user.getBirthday());

        userRepository.save(updatedUser);
    }

    public void deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException();
        }

        userRepository.delete(user.get());
    }
}