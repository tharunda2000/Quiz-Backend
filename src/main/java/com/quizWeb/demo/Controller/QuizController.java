package com.quizWeb.demo.Controller;

import com.quizWeb.demo.DTO.QuizDTO;
import com.quizWeb.demo.Model.Quiz;
import com.quizWeb.demo.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/allQuiz")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @PostMapping("/quiz")
    public QuizDTO setQuiz(@RequestBody QuizDTO quizDTO, @RequestParam int userId){
        quizService.setQuiz(quizDTO,userId);
        return quizDTO;
    }

    @GetMapping("/quiz/{id}")
    public Quiz getQuiz(@PathVariable Long id){
        return quizService.getQuiz(id);

    }

    @DeleteMapping("/quiz/{id}")
    public void deleteQuiz(@PathVariable Long id){
        quizService.deleteQuiz(id);
    }

    @PutMapping("/quiz/{id}")
    public void editQuiz(@PathVariable Long id,@RequestBody QuizDTO quizDTO){
        quizService.editQuiz(id,quizDTO);
    }



}
