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

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getallUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById( id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        userService.addUser(user);
        return user;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/user/{id}")
    public User edituser(@RequestBody User user,@PathVariable int id){
        userService.editUser(user,id);
        return user;
    }


}
