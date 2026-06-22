package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.dto.other.ContestProblemWithContest;

import java.util.List;

public interface ContestProblemService {

    void createContestProblem(Long contestId, Long problemId);

    ContestProblemDto findByProblemIdAndContestId(Long problemId, Long contestId);

    ContestProblemWithContest findByProblemIdAndContestIdJoinContest(Long problemId, Long contestId);

    void removeContestProblem(Long id);

    List<ContestProblemDto> findByContestId(Long contestId);

}
