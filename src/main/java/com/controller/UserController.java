package com.controller;
import com.model.Loan;
import com.model.User;
import com.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userService")
public class UserController {

    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        logger.info("All account holders list");
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public User createEmployee(@RequestBody User user) {
        logger.info("Create Employee is invoked {}", user);
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        logger.info("User showed");
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {return userService.updateUser(user);}

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable("id") int id) {return userService.deleteUser(id);}

}
