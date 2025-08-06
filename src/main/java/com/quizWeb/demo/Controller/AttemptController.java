package com.quizWeb.demo.Controller;

import com.quizWeb.demo.Model.Attempt;
import com.quizWeb.demo.Service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttemptController {

    @Autowired
    AttemptService attemptService;

    @PostMapping("/attempt")
    public void createAttempt(@RequestBody Attempt attempt, @RequestParam int userId, @RequestParam Long quizId){

        attemptService.createAttempt(attempt,userId,quizId);

    }
}
