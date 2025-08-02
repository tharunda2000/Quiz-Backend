package com.quizWeb.demo.Repository;

import com.quizWeb.demo.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
