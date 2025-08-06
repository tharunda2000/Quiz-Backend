package com.quizWeb.demo.Service;

import com.quizWeb.demo.DTO.AttemptStartDTO;
import com.quizWeb.demo.DTO.AttemptSubmitDto;
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

    public void createAttempt(AttemptStartDTO attemptStartDTO, int userId, Long quizId) {

        Attempt attempt = new Attempt();

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        attempt.setQuiz(quiz);
        attempt.setUser(user);
        attempt.setStartTime(attemptStartDTO.getStartTime());

        attemptRepo.save(attempt);


    }

    public void submitAttempt(AttemptSubmitDto attemptSubmitDto, int userId, Long quizId) {
        Attempt attempt = new Attempt();

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        attempt.setQuiz(quiz);
        attempt.setUser(user);
        attempt.setEndTime(attemptSubmitDto.getEndTime());
        attempt.setMarks(attemptSubmitDto.getMarks());

        attemptRepo.save(attempt);

    }
}
