package com.quizWeb.demo.Service;

import com.quizWeb.demo.Model.Attempt;
import com.quizWeb.demo.Model.Quiz;
import com.quizWeb.demo.Model.User;
import com.quizWeb.demo.Repository.AttemptRepository;
import com.quizWeb.demo.Repository.QuizRepository;
import com.quizWeb.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {

    @Autowired
    AttemptRepository attemptRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    QuizRepository quizRepo;

    public void createAttempt(Attempt attempt, int userId, Long quizId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        attempt.setQuiz(quiz);
        attempt.setUser(user);

        attemptRepo.save(attempt);


    }
}
