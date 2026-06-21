package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.repository.entity.ContestProblem;

public interface ContestProblemService {

    void createContestProblem(Long contestId, Long problemId);

    ContestProblemDto getById(Long contestId);

    ContestProblemDto findByProblemIdAndContestId(Long problemId, Long contestId);
}
