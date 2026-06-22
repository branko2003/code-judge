package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.*;
import com.branko.midlevel.codejudge.dto.request.SumissionResultContestByUserRequest;
import com.branko.midlevel.codejudge.dto.request.SumissionResultRequest;
import com.branko.midlevel.codejudge.dto.response.SubmissionResultByContestResponse;
import com.branko.midlevel.codejudge.dto.response.SubmissionResultResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionResultContestByUserUseCase {

    private final SubmissionService submissionService;
    private final ContestProblemService contestProblemService;
    private final SubmissionResultService submissionResultService;
    private final UserService userService;
    private final ProblemService problemService;
    private final MessageUtil messageUtil;
    private final ContestEnrollmentService contestEnrollmentService;

    public SubmissionResultResponse execute(SumissionResultContestByUserRequest request) {
        List<ContestProblemDto> contestProblemList = this.validate(request);
        UserDto userDto = userService.getById(UserContext.getUserId());
        List<SubmissionProblem> submissionProblemList = new ArrayList<>();
        for (ContestProblemDto contestProblemDto : contestProblemList) {
            List<SubmissionDto> submissionDtoList = submissionService.getSubmissionByUserIdAndContestProblemId(request.getUserId(), contestProblemDto.getId());
            ProblemDto problemDto = problemService.getById(contestProblemDto.getProblemId());
            SubmissionResultUserDto results = new SubmissionResultUserDto();
            for (SubmissionDto submission : submissionDtoList) {
                results.setSubmissionDtoList(submissionResultService.getResultBySubmissionId(submission.getId()));
                results.setTotalTestCase(submission.getTotal());
                results.setPassedTestCase(submission.getPassed());
            }
            submissionProblemList.add(new SubmissionProblem(problemDto, results));
        }
        return new SubmissionResultResponse(userDto, submissionProblemList);
    }

    private List<ContestProblemDto> validate(SumissionResultContestByUserRequest request) {
        List<ContestProblemDto> contestProblemList = contestProblemService.findByContestId(request.getContestId());
        if (contestProblemList.isEmpty()) {
            throw new BadRequestException(messageUtil.get("contest.problem.empty"));
        }
        ContestEnrollmentDto contestEnrollmentDto = contestEnrollmentService.getByUserIdAndContestId(UserContext.getUserId(), request.getContestId());
        if (contestEnrollmentDto == null) {
            throw new BadRequestException(messageUtil.get("contest.enrollment.notfound"));

        }
        return contestProblemList;
    }
}
