package com.quizWeb.demo.Repository;

import com.quizWeb.demo.Model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option,Long> {
}
