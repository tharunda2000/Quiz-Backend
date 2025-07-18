package com.quizWeb.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private String quizName;
    private int duration;
    private String accessKey;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    private List<Attempt> attempts;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    private List<Question> questions;

}
