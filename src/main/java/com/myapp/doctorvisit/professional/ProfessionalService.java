package com.myapp.doctorvisit.professional;

import com.myapp.doctorvisit.professional.exception.ProffesionalNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionalService {

    private final ProfessionalRepository professionalRepository;


    public Professional create(Professional professional) {
        return professionalRepository.save(professional);
    }

    public boolean existsById(Integer id) {
        return professionalRepository.existsById(id);
    }

    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    public Professional getById(Integer id) {
        return professionalRepository.findById(id).orElseThrow(ProffesionalNotFoundException::new);
    }

    public void deleteById(Integer id) {
        Professional professional = getById(id);
        professionalRepository.delete(professional);
    }
}
