package com.myapp.doctorvisit.rate.controller;

import com.myapp.doctorvisit.rate.Rate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRatesDto {
    private List<Rate> rates;
    private Float averageScore;
}
