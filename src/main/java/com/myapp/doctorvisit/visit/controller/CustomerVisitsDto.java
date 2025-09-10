package com.myapp.doctorvisit.visit.controller;

import com.myapp.doctorvisit.visit.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVisitsDto {
    List<VisitDto> lastVisits;
    List<VisitDto> onGoingVisits;
}
