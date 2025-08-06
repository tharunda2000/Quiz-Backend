package com.quizWeb.demo.Repository;

import com.quizWeb.demo.Model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepository extends JpaRepository<Attempt,Long> {
}
