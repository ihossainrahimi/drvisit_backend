package com.myapp.doctorvisit.rate.controller;

import com.myapp.doctorvisit.rate.Rate;
import com.myapp.doctorvisit.rate.RateService;
import com.myapp.doctorvisit.rate.controller.DoctorRatesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rates")
@Transactional
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @PostMapping()
    public Rate createRate(@RequestBody Rate rate) {
        return rateService.create(rate);
    }

    @GetMapping("/doctors/{doctorId}")
    public DoctorRatesDto getAllRatesByDoctorId(@PathVariable Integer doctorId) {
        return rateService.findAllByDoctorId(doctorId);
    }

    @GetMapping("/{id}")
    public Rate getRate(@PathVariable("id") Integer id) {
        return rateService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable("id") Integer id) {
        rateService.deleteById(id);
    }


}
