package com.quizWeb.demo.DTO;

import lombok.Data;

@Data
public class QuizDTO {

    private String quizName;
    private int duration;
    private String accessKey;
    private int userId;
}
