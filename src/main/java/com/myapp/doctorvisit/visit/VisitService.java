package com.myapp.doctorvisit.visit;

import com.myapp.doctorvisit.visit.controller.VisitCreationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

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
        if (from != null) {
            LocalDateTime to = from.plusDays(1).atStartOfDay();
            return visitRepository.findAllFreeByDoctorIdAndBetweenDates(doctorId, from.atStartOfDay(), to)
                    .stream()
                    .filter(item -> item.getStartedAt().isBefore(LocalDateTime.now()))
                    .collect(Collectors.toList());
        } else return visitRepository.findAllFreeByDoctorId(doctorId);
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
}
