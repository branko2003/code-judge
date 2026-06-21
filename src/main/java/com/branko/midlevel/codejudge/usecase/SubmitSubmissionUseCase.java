package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.dto.request.SubmitSumissionRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.mapper.SubmissionMapper;
import com.branko.midlevel.codejudge.repository.entity.ContestEnrollment;
import com.branko.midlevel.codejudge.repository.entity.ContestProblem;
import com.branko.midlevel.codejudge.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SubmitSubmissionUseCase {

    private final SubmissionService submissionService;
    private final ContestProblemService contestProblemService;
    private final SubmissionMapper submissionMapper;
    private final ContestEnrollmentService contestEnrollmentService;

    public CommonResponse execute(SubmitSumissionRequest request) {
        this.validate(request);
        submissionService.createSubmission(submissionMapper.submissionFromMapSubmitSubmissionRequest(request));
        return new CommonResponse();
    }

    private void validate(SubmitSumissionRequest request) {
        ContestProblemDto contestProblemDto = contestProblemService.findByProblemIdAndContestId(request.getProblemId(), request.getContestId());
        if (contestProblemDto == null) {
            throw new BadRequestException("");
        }

        if (contestProblemDto.getContest().getStartTime().isAfter(LocalDateTime.now())) {
            throw new BadRequestException("Contest has not started yet");
        }

        if (contestProblemDto.getContest().getEndTime().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Contest has already ended");
        }

        ContestEnrollmentDto contestEnrollmentDto = contestEnrollmentService.getByUserIdAndContestId(UserContext.getUserId(), request.getContestId());
        if (contestEnrollmentDto == null) {
            throw new BadRequestException("");
        }
    }
}
