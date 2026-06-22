package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.request.UpdateContestRequest;
import com.branko.midlevel.codejudge.repository.entity.Contest;

import java.time.LocalDateTime;

public interface ContestService {

    ContestDto createContest(Contest contest);

    ContestDto getById(Long contestId);

    ContestDto updateContest(UpdateContestRequest request);

    void closeExpiredContests(LocalDateTime time);

    void startContests(LocalDateTime time);
}
