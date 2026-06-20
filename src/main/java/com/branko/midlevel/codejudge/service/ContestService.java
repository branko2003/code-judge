package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.repository.entity.Contest;

public interface ContestService {

    ContestDto createContest(Contest contest);

    ContestDto getById(Long contestId);

}
