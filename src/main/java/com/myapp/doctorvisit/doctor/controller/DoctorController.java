package com.myapp.doctorvisit.doctor.controller;

import com.myapp.doctorvisit.doctor.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/professionals/{id}")
    public DoctorProfessionalDto getAllDoctorsByProfessional(@PathVariable int id) {
        return doctorService.getAllDoctorsByProfessional(id);
    }
}
