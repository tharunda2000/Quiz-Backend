package com.quizWeb.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    private List<Attempt> attempts;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    private List<Question> questions;

}
