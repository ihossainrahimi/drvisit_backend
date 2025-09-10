package com.myapp.doctorvisit.visit.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {

    private Integer id;
    private Integer doctorId;
    private String doctorTitle;
    private String professional;
    private Long price;
    private Integer customerId;
    private LocalDateTime startedAt;
    private LocalDateTime endAt;
    private Integer duration;
    private Boolean isFree;
    private LocalDateTime createdAt;
}
