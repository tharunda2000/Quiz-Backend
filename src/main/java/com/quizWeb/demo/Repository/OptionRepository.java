package com.quizWeb.demo.Repository;


import com.quizWeb.demo.Model.OptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<OptionModel,Long> {
}
