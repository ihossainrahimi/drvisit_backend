package com.myapp.doctorvisit.visit.controller;

import com.myapp.doctorvisit.visit.Visit;
import com.myapp.doctorvisit.visit.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/visits")
public class VisitController {

    private final VisitService visitService;

    @PostMapping
    public List<Visit> createSchedule(@RequestBody VisitCreationDto dto) {
        return visitService.create(dto);
    }

    @GetMapping("/doctors/{doctorId}")
    public List<Visit> findAllByDoctorIdAndBetweenDates(@PathVariable Integer doctorId, @RequestParam LocalDate from) {
        return visitService.findAllFreeByDoctorIdAndBetweenDates(doctorId, from);
    }

    @PutMapping("/{id}/customers/{customerId}")
    public void updateScheduleAvailability(@PathVariable Integer id, @PathVariable Integer customerId) {
        visitService.updateScheduleAvailability(id, customerId);
    }

    @GetMapping("/{id}")
    public Visit getSchedule(@PathVariable("id") Integer id) {
        return visitService.getById(id);
    }

    @DeleteMapping()
    public void deleteBatchSchedules(@RequestBody List<Integer> ids) {
        visitService.deleteBatchVisits(ids);
    }
}
