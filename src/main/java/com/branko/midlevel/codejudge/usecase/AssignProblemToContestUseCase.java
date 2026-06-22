package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.dto.request.ProblemToContestRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.service.ContestEnrollmentService;
import com.branko.midlevel.codejudge.service.ContestProblemService;
import com.branko.midlevel.codejudge.service.ContestService;
import com.branko.midlevel.codejudge.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignProblemToContestUseCase {

    private final ProblemService problemService;
    private final ContestService contestService;
    private final ContestProblemService contestProblemService;
    private final ContestEnrollmentService contestEnrollmentService;
    private final MessageUtil messageUtil;

    public CommonResponse execute(ProblemToContestRequest request) {
        validate(request);
        contestProblemService.createContestProblem(request.getContestId(), request.getProblemId());
        return new CommonResponse();
    }

    private void validate(ProblemToContestRequest request) {
        ContestDto contest = contestService.getById(request.getContestId());
        if (contest == null) {
            throw new BadRequestException(messageUtil.get("contest.notfound"));
        }
        ProblemDto problemDto = problemService.getById(request.getProblemId());
        if (problemDto == null) {
            throw new BadRequestException(messageUtil.get("problem.notfound"));
        }
        ContestProblemDto contestProblemDto = contestProblemService.findByProblemIdAndContestId(problemDto.getId(), contest.getId());
        if (contestProblemDto != null) {
            throw new BadRequestException(messageUtil.get("contest.problem.already.exists"));
        }
        ContestEnrollmentDto contestEnrollmentDto = contestEnrollmentService.getByUserIdAndContestId(UserContext.getUserId(), contest.getId());
        if (contestEnrollmentDto == null) {
            throw new BadRequestException(messageUtil.get("contest.enrollment.notfound"));
        }
    }
}
