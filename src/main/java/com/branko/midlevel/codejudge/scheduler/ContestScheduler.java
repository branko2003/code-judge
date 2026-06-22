package com.branko.midlevel.codejudge.scheduler;

import com.branko.midlevel.codejudge.service.ContestService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ContestScheduler {

    private final ContestService contestService;

    @Scheduled(fixedDelay = 60000)
    public void updateStatusContests() {
        contestService.closeExpiredContests(LocalDateTime.now());
        contestService.startContests(LocalDateTime.now());
    }
}
