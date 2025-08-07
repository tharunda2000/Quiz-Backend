package com.quizWeb.demo.Service;


import com.quizWeb.demo.DTO.QuizDTO;
import com.quizWeb.demo.Model.Quiz;
import com.quizWeb.demo.Model.User;
import com.quizWeb.demo.Repository.QuizRepository;
import com.quizWeb.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository QuizRepo;

    @Autowired
    UserRepository userRepo;


    public List<Quiz> getAllQuiz() {
        return QuizRepo.findAll();
    }

    public void setQuiz(QuizDTO quizDTO, int userId) {

        Quiz quiz = new Quiz();

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        quiz.setUser(user);
        quiz.setQuizName(quizDTO.getQuizName());
        quiz.setQuizType(quizDTO.getQuizType());
        quiz.setDuration(quizDTO.getDuration());
        quiz.setAccessKey(quizDTO.getAccessKey());
        QuizRepo.save(quiz);
    }

    public Quiz getQuiz(Long id) {
        return QuizRepo.findById(id).get();

    }

    public void deleteQuiz(Long id) {
        QuizRepo.deleteById(id);
    }

    public void editQuiz(Long id, QuizDTO quizDTO) {
        Quiz currentQuiz = QuizRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Quiz does not found"));

        currentQuiz.setQuizName(quizDTO.getQuizName());
        currentQuiz.setQuizType(quizDTO.getQuizType());
        currentQuiz.setDuration(quizDTO.getDuration());
        currentQuiz.setAccessKey(quizDTO.getAccessKey());

        QuizRepo.save(currentQuiz);

    }
}
