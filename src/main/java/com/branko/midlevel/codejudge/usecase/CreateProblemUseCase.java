package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.dto.request.CreateProblemRequest;
import com.branko.midlevel.codejudge.dto.response.ProblemResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.ProblemMapper;
import com.branko.midlevel.codejudge.service.ContestProblemService;
import com.branko.midlevel.codejudge.service.ContestService;
import com.branko.midlevel.codejudge.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProblemUseCase {

    private final ProblemService problemService;
    private final ProblemMapper problemMapper;
    private final ContestService contestService;
    private final ContestProblemService contestProblemService;
    private final MessageUtil messageUtil;

    public ProblemResponse execute(CreateProblemRequest request) {
        ProblemDto problem = problemService.createProblem(problemMapper.problemFromMapCreateProblemRequest(request));
        if (request.getContestId() != null) {
            assignProblemToContest(request.getContestId(), problem.getId());
        }
        return new ProblemResponse(problem);
    }

    private ContestDto validate(Long contestId) {
        ContestDto contest = contestService.getById(contestId);
        if (contest == null) {
            throw new BadRequestException(messageUtil.get("contest.notfound"));
        }
        return contest;
    }

    private void assignProblemToContest(Long contestId, Long problemId) {
        ContestDto contest = this.validate(contestId);
        contestProblemService.createContestProblem(contest.getId(), problemId);
    }
}
