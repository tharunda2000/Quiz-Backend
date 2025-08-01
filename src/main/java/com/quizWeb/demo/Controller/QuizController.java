package com.quizWeb.demo.Controller;

import com.quizWeb.demo.Model.Quiz;
import com.quizWeb.demo.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.classfile.constantpool.LongEntry;
import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/allQuizes")
    public List<Quiz> getAllQuizes(){
        return quizService.getAllQuizes();
    }

    @PostMapping("/quiz")
    public Quiz setQuiz(@RequestBody Quiz quiz){
        quizService.setQuiz(quiz);
        return quiz;
    }

    @GetMapping("/quiz/{id}")
    public Quiz getQuize(@PathVariable Long id){
        return quizService.getQuize();

    }

    @DeleteMapping("/quiz/{id}")
    public void deleteQuiz(@PathVariable Long id){
        quizService.deleteQuiz(id);
    }

    @PutMapping("/quiz/{id}")
    public void editQuiz(@PathVariable Long id){
        quizService.editQuiz(id);
    }



}
