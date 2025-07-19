package com.quizWeb.demo.Controller;

import com.quizWeb.demo.Model.User;
import com.quizWeb.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getallUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById( id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        userService.addUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PutMapping("/user")
    public User edituser(@RequestBody User user){
        userService.editUser(user);
        return user;
    }


}
