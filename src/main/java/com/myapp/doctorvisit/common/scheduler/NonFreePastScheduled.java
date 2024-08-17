package com.myapp.doctorvisit.common.scheduler;

import com.myapp.doctorvisit.visit.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NonFreePastScheduled {
    private final VisitService visitService;


    @Scheduled(fixedRate = 60 * 1000)
    public void updateAllByIsFreeAndFromBeforeNow() {
        visitService.updateAllByIsFreeAndFromBeforeNow();
    }
}
