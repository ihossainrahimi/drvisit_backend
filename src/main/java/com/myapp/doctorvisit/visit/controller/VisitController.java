package com.myapp.doctorvisit.visit.controller;

import com.myapp.doctorvisit.user.User;
import com.myapp.doctorvisit.user.UserService;
import com.myapp.doctorvisit.visit.Visit;
import com.myapp.doctorvisit.visit.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/visits")
public class VisitController {

    private final VisitService visitService;
    private final UserService userService;

    //this comment is that client call bad api for update and to not change the client I forced to
    //write updateUserInfo on this api.
//    @PostMapping
//    public List<Visit> createSchedule(@RequestBody VisitCreationDto dto) {
//        return visitService.create(dto);
//    }

    @PostMapping
    public User updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    @GetMapping("/doctors/{doctorId}")
    public List<Visit> findAllByDoctorIdAndBetweenDates(@PathVariable Integer doctorId, @RequestParam(required = false) LocalDate from) {
        return visitService.findAllFreeByDoctorIdAndBetweenDates(doctorId, from);
    }

    @GetMapping("/doctors/{doctorId}/all")
    public List<Visit> getAllDoctorVisits(@PathVariable Integer doctorId, @RequestParam LocalDate from, @RequestParam LocalDate to) {
        return visitService.getAllDoctorsVisitsByOptionalDate(doctorId, from, to);
    }

    @GetMapping("/customers/{customerId}")
    public CustomerVisitsDto getCustomerVisits(@PathVariable Integer customerId) {
        return visitService.getALlCustomerVisits(customerId);
    }

    @PostMapping("/{id}/customers/{customerId}")
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
