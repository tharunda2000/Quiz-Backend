package com.quizWeb.demo.Service;

import com.quizWeb.demo.DTO.QuestionDTO;
import com.quizWeb.demo.Model.Question;
import com.quizWeb.demo.Model.Quiz;
import com.quizWeb.demo.Repository.QuestionRepository;
import com.quizWeb.demo.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepo;
    
    @Autowired
    QuizRepository quizRepo;

    public Question setQuestion(QuestionDTO questionDTO, Long quizId) {
        Question question = new Question();

        question.setQuestionText(questionDTO.getQuestionText());
        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        question.setQuiz(quiz);
        return questionRepo.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public Question getQuestion(Long questionId) {
        return questionRepo.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found with id.cant get: " + questionId));
    }

    public void editQuestion(Question question, Long id) {
        Question currentQuestion = questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id.cant edit: " + id));

        currentQuestion.setQuestionText(question.getQuestionText());

        questionRepo.save(currentQuestion);
    }

    public Question deleteQuestion(Long id) {
        Question question = questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id.cant delete: " + id));
        questionRepo.deleteById(id);
        return question;
    }
}
