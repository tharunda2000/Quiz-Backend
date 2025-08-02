package com.quizWeb.demo.Controller;

import com.quizWeb.demo.Model.Question;
import com.quizWeb.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/Question")
    public Question setQuestion(@RequestBody Question question,@RequestParam Long quizId){

        return questionService.setQuestion(question,quizId);
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/question/{questionId}")
    public  Question getQuestion(@PathVariable Long questionId){
        return questionService.getQuestion(questionId);
    }

    @PutMapping("/question/{id}")
    public void editQuestion(@RequestBody Question question,@PathVariable Long id){
        questionService.editQuestion(question,id);
    }

    @DeleteMapping("/question/{id}")
    public Question deleteQuestion(@PathVariable Long id){
        return questionService.deleteQuestion(id);
    }

    
}
