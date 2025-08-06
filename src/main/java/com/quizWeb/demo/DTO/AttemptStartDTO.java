package com.quizWeb.demo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttemptStartDTO {

    private int marks;
    private LocalDateTime startTime;
    private int userId;
    private Long quizId;
}
