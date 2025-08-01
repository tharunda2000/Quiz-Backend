package com.quizWeb.demo.Repository;

import com.quizWeb.demo.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {


}
