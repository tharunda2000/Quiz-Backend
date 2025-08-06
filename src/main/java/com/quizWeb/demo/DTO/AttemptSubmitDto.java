package com.quizWeb.demo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttemptSubmitDto {

    private int marks;
    private LocalDateTime endTime;
    private int userId;
    private Long quizId;
}
