package com.branko.midlevel.codejudge.usecase.problem;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.dto.request.ProblemToContestRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.service.ContestEnrollmentService;
import com.branko.midlevel.codejudge.service.ContestProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveProblemToContestUseCase {

    private final ContestProblemService contestProblemService;
    private final ContestEnrollmentService contestEnrollmentService;
    private final MessageUtil messageUtil;

    public CommonResponse execute(ProblemToContestRequest request) {
        validate(request.getContestId());
        ContestProblemDto contestProblemDto = contestProblemService.findByProblemIdAndContestId(request.getProblemId(), request.getContestId());
        if (contestProblemDto == null) {
            return new CommonResponse();
        }
        contestProblemService.removeContestProblem(contestProblemDto.getId());
        return new CommonResponse();
    }

    private void validate(Long contestId) {
        ContestEnrollmentDto contestEnrollmentDto = contestEnrollmentService.getByUserIdAndContestId(UserContext.getUserId(), contestId);
        if (contestEnrollmentDto == null) {
            throw new BadRequestException(messageUtil.get("contest.enrollment.notfound"));
        }
    }
}
