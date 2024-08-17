package com.myapp.doctorvisit.doctor.controller;

import com.myapp.doctorvisit.doctor.Doctor;
import com.myapp.doctorvisit.professional.Professional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorProfessionalDto {
    private List<Doctor> doctors;
    private Professional professional;
}
