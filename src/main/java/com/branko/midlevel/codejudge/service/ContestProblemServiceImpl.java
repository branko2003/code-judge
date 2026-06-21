package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.repository.ContestProblemRepository;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.repository.entity.ContestProblem;
import com.branko.midlevel.codejudge.repository.entity.Problem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContestProblemServiceImpl implements ContestProblemService {

    private final ContestProblemRepository contestProblemRepository;

    @Override
    public void createContestProblem(Long contestId, Long problemId) {
        contestProblemRepository.save(buildContestProblem(contestId, problemId));
    }

    @Override
    public ContestProblemDto getById(Long contestId) {
        return null;
    }

    @Override
    public ContestProblemDto findByProblemIdAndContestId(Long problemId, Long contestId) {
        contestProblemRepository.findByContestIdAndProblemId(contestId, problemId);
    }

    private ContestProblem buildContestProblem(Long contestId, Long problemId) {
        ContestProblem contestProblem = new ContestProblem();
        Contest contest = new Contest();
        contest.setId(contestId);
        Problem problem = new Problem();
        contest.setId(problemId);
        contestProblem.setProblem(problem);
        contestProblem.setContest(contest);
        return contestProblem;
    }
}
