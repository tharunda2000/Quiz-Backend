package com.quizWeb.demo.Controller;

import com.quizWeb.demo.DTO.AttemptStartDTO;
import com.quizWeb.demo.DTO.AttemptSubmitDto;
import com.quizWeb.demo.Model.Attempt;
import com.quizWeb.demo.Service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttemptController {

    @Autowired
    AttemptService attemptService;

    @PostMapping("/attemptStart")
    public void createAttempt(@RequestBody AttemptStartDTO attemptStartDTO, @RequestParam int userId, @RequestParam Long quizId){
        attemptService.createAttempt(attemptStartDTO,userId,quizId);
    }

    @PutMapping("/attemptEnd")
    public void submitAttempt(@RequestBody AttemptSubmitDto attemptSubmitDto,@PathVariable Long attemptId){
        attemptService.submitAttempt(attemptSubmitDto,attemptId);
    }


}
