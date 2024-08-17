package com.myapp.doctorvisit.doctor;

import com.myapp.doctorvisit.doctor.controller.DoctorProfessionalDto;
import com.myapp.doctorvisit.professional.Professional;
import com.myapp.doctorvisit.professional.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ProfessionalService professionalService;

    public DoctorProfessionalDto getAllDoctorsByProfessional(int professionalId) {
        List<Doctor> doctors = doctorRepository.findAllByProfessionalId(professionalId);
        Professional professional = professionalService.getById(professionalId);
        return new DoctorProfessionalDto(doctors, professional);
    }

    public Doctor getById(Integer doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(DoctorNotFoundException::new);
    }
}
