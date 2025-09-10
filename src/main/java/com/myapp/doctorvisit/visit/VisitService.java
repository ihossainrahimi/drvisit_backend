package com.myapp.doctorvisit.visit;

import com.myapp.doctorvisit.doctor.Doctor;
import com.myapp.doctorvisit.doctor.DoctorRepository;
import com.myapp.doctorvisit.professional.Professional;
import com.myapp.doctorvisit.professional.ProfessionalRepository;
import com.myapp.doctorvisit.visit.controller.CustomerVisitsDto;
import com.myapp.doctorvisit.visit.controller.VisitCreationDto;
import com.myapp.doctorvisit.visit.controller.VisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final DoctorRepository doctorRepository;
    private final ProfessionalRepository professionalRepository;

    public List<Visit> create(VisitCreationDto dto) {
        List<Visit> visits = new ArrayList<>();
        LocalDateTime startTime = dto.getStartedAt();
        while (startTime.isBefore(dto.getEndAt())) {
            Visit visit = new Visit();

            Integer existedVisit = visitRepository.findByDoctorIdAndVisitBetweenStartAndEnd(dto.getDoctorId(), dto.getStartedAt(), dto.getEndAt());
            if (existedVisit != null && existedVisit > 0) {
                break;
            }

            visit.setStartedAt(dto.getStartedAt());
            visit.setDuration(dto.getDuration());
            visit.setDoctorId(dto.getDoctorId());
            visit.setIsFree(true);

            startTime = startTime.plusMinutes(dto.getDuration());
            visit.setEndAt(startTime);
            startTime = startTime.plusMinutes(1);

            visits.add(visit);
            visitRepository.save(visit);
        }

        return visits;
    }

    public List<Visit> findAllFreeByDoctorIdAndBetweenDates(Integer doctorId, LocalDate from) {
        return visitRepository.findAllFreeByDoctorId(doctorId);
    }

    public Visit getById(Integer id) {
        return visitRepository.findById(id).orElseThrow(VisitNotFoundException::new);
    }

    public void deleteBatchVisits(List<Integer> ids) {
        for (Integer id : ids) {
            try {
                Visit visit = getById(id);
                visitRepository.delete(visit);
            } catch (Exception ignored) {
            }
        }
    }

    public void updateAllByIsFreeAndFromBeforeNow() {
        visitRepository.updateAllByIsFreeAndFromBeforeNow();
    }

    public void updateScheduleAvailability(Integer id, Integer customerId) {
        visitRepository.updateVisitAvailability(id, customerId);
    }

    public List<Visit> getAllDoctorsVisitsByOptionalDate(Integer doctorId, LocalDate from, LocalDate to) {
        if (from != null) {
            return visitRepository.findAllByDoctorIdAndBetweenDates(doctorId, from.atStartOfDay(), to.atStartOfDay());
        } else return visitRepository.findAllByDoctorId(doctorId);
    }

    public CustomerVisitsDto getALlCustomerVisits(Integer customerId) {
        List<VisitDto> onGoingVisits = new ArrayList<>();
        List<VisitDto> lastVisits = new ArrayList<>();
        List<Visit> visits = visitRepository.findAllByCustomerId(customerId);

        visits.stream().filter(item -> item.getStartedAt().isBefore(LocalDateTime.now())).forEach(item -> {
            Doctor doctor = doctorRepository.findById(item.getDoctorId()).orElseThrow();
            Professional professional = professionalRepository.findById(doctor.getProfessionalId()).orElseThrow();
            var visitDto = new VisitDto(item.getId(), item.getDoctorId(), doctor.getTitle(), professional.getTitle(), doctor.getVisitFee(), item.getCustomerId(), item.getStartedAt(), item.getEndAt(), item.getDuration(), item.getIsFree(), item.getCreatedAt());
            onGoingVisits.add(visitDto);
        });
        visits.stream().filter(item -> item.getStartedAt().isAfter(LocalDateTime.now())).forEach(item -> {
            Doctor doctor = doctorRepository.findById(item.getDoctorId()).orElseThrow();
            Professional professional = professionalRepository.findById(doctor.getProfessionalId()).orElseThrow();
            var visitDto = new VisitDto(item.getId(), item.getDoctorId(), doctor.getTitle(), professional.getTitle(), doctor.getVisitFee(), item.getCustomerId(), item.getStartedAt(), item.getEndAt(), item.getDuration(), item.getIsFree(), item.getCreatedAt());
            lastVisits.add(visitDto);
        });
        return new CustomerVisitsDto(onGoingVisits, lastVisits);
    }
}
