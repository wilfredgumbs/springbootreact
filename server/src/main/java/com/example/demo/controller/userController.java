package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@RestController
public class userController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    public List<User> getUsers() {
        List<User> myList = new LinkedList<User>();
        for (User e : repository.findAll()) {
            myList.add(e);
        }
        return myList;
    }

    @PostMapping("/user/new")
    public User createUsers(@RequestBody User user) {

        return repository.save(user);

    }
}



