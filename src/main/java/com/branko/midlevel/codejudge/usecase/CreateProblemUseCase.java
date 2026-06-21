package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.dto.request.CreateProblemRequest;
import com.branko.midlevel.codejudge.dto.response.ProblemResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
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

    public ProblemResponse execute(CreateProblemRequest request) {
        ContestDto contest = this.validate(request);
        ProblemDto problem = problemService.createProblem(problemMapper.problemFromMapCreateProblemRequest(request));
        contestProblemService.createContestProblem(contest.getId(), problem.getId());
        return new ProblemResponse(problem);
    }

    private ContestDto validate(CreateProblemRequest request) {
        ContestDto contest = contestService.getById(request.getContestId());
        if (contest == null) {
            throw new BadRequestException("asd");
        }
        return contest;
    }
}
