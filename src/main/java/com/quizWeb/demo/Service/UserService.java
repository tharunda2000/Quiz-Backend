package com.quizWeb.demo.Service;

import com.quizWeb.demo.Model.User;
import com.quizWeb.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<User> getallUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public void editUser(User user, int id) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(()->new RuntimeException("User does not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        userRepo.save(existingUser);

    }
}
