package com.branko.midlevel.codejudge.usecase.submission;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.*;
import com.branko.midlevel.codejudge.dto.request.SumissionResultRequest;
import com.branko.midlevel.codejudge.dto.response.SubmissionResultResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionResultContestUseCase {

    private final SubmissionService submissionService;
    private final ContestProblemService contestProblemService;
    private final SubmissionResultService submissionResultService;
    private final UserService userService;
    private final ProblemService problemService;
    private final MessageUtil messageUtil;

    public SubmissionResultResponse execute(SumissionResultRequest request) {
        ContestProblemDto contestProblemDto = this.validate(request);
        List<SubmissionDto> submissionDtoList = submissionService.getSubmissionByUserIdAndContestProblemId(UserContext.getUserId(), contestProblemDto.getId());
        UserDto userDto = userService.getById(UserContext.getUserId());
        ProblemDto problem = problemService.getById(contestProblemDto.getId());
        SubmissionResultUserDto results = new SubmissionResultUserDto();
        for (SubmissionDto submission : submissionDtoList) {
            results.setSubmissionDtoList(submissionResultService.getResultBySubmissionId(submission.getId()));
            results.setTotalTestCase(submission.getTotal());
            results.setPassedTestCase(submission.getPassed());
        }

        return new SubmissionResultResponse(userDto, List.of(new SubmissionProblem(problem, results)));
    }

    private ContestProblemDto validate(SumissionResultRequest request) {
        ContestProblemDto contestProblemDto = contestProblemService.findByProblemIdAndContestId(request.getProblemId(), request.getContestId());
        if (contestProblemDto == null) {
            throw new BadRequestException(messageUtil.get("contest.problem.notfound"));
        }
        return contestProblemDto;
    }
}
