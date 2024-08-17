package com.myapp.doctorvisit.rate;

import com.myapp.doctorvisit.rate.controller.DoctorRatesDto;
import com.myapp.doctorvisit.rate.exceptions.RateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;

    public Rate create(Rate rate) {
        return rateRepository.save(rate);
    }

    public boolean existsById(Integer id) {
        return rateRepository.existsById(id);
    }

    public DoctorRatesDto findAllByDoctorId(Integer doctorId) {
        List<Rate> rates = rateRepository.findAllByDoctorId(doctorId);
        Float sumScores = rates.stream().map(Rate::getScore).reduce(Float::sum).orElse(null);
        Float averageScore = sumScores != null ? sumScores / rates.size() : null;
        return new DoctorRatesDto(rates, averageScore);
    }

    public Rate getById(Integer id) {
        return rateRepository.findById(id).orElseThrow(RateNotFoundException::new);
    }

    public void deleteById(Integer id) {
        Rate rate = getById(id);
        rateRepository.delete(rate);
    }
}
