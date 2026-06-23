package com.branko.midlevel.codejudge.usecase.submission;

import com.branko.midlevel.codejudge.constant.JudgeLanguageStrategyName;
import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.*;
import com.branko.midlevel.codejudge.dto.request.SubmitSumissionRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.SubmissionMapper;
import com.branko.midlevel.codejudge.service.*;
import com.branko.midlevel.codejudge.service.async.judge.JudgeServiceAsync;
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
    private final JudgeServiceAsync judgeServiceAsync;
    private final MessageUtil messageUtil;

    public CommonResponse execute(SubmitSumissionRequest request) {
        ContestProblemWithContest contestProblem = this.validate(request);
        request.setUserId(UserContext.getUserId());
        SubmissionDto submissionDto = submissionService.createSubmission(submissionMapper.submissionFromMapSubmitSubmissionRequest(request, contestProblem.getId()));
        judgeServiceAsync.processSubmission(submissionDto, request.getProblemId());
        return new CommonResponse();
    }

    private ContestProblemWithContest validate(SubmitSumissionRequest request) {
        ContestProblemWithContest contestProblemDto = contestProblemService.findByProblemIdAndContestIdJoinContest(request.getProblemId(), request.getContestId());
        if (contestProblemDto == null) {
            throw new BadRequestException(messageUtil.get("contest.problem.notfound"));
        }

        if (contestProblemDto.getContest().getStartTime().isAfter(LocalDateTime.now())) {
            throw new BadRequestException(messageUtil.get("contest.not.started"));
        }

        if (contestProblemDto.getContest().getEndTime().isBefore(LocalDateTime.now())) {
            throw new BadRequestException(messageUtil.get("contest.already.ended"));
        }

        ContestEnrollmentDto contestEnrollmentDto = contestEnrollmentService.getByUserIdAndContestId(UserContext.getUserId(), request.getContestId());

        if (contestEnrollmentDto == null) {
            throw new BadRequestException(messageUtil.get("contest.enrollment.notfound"));
        }

        String language = request.getLanguage().trim().toLowerCase();
        if (!JudgeLanguageStrategyName.isAllowedLanguage(language)) {
            throw new BadRequestException(messageUtil.get("submission.language.invalid"));
        }
        request.setLanguage(language);
        return contestProblemDto;
    }
}
