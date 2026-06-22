package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.dto.request.UpdateContestRequest;
import com.branko.midlevel.codejudge.dto.response.ContestResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.service.ContestEnrollmentService;
import com.branko.midlevel.codejudge.service.ContestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateContestUseCase {

    private final ContestService contestService;
    private final ContestEnrollmentService contestEnrollmentService;
    private final MessageUtil messageUtil;

    public ContestResponse execute(UpdateContestRequest request) {
        this.validate(request.getId());
        ContestDto contestUpdate = contestService.updateContest(request);
        return new ContestResponse(contestUpdate);
    }

    private void validate(Long contestId) {
        ContestEnrollmentDto contestEnrollmentDto = contestEnrollmentService.getByUserIdAndContestId(UserContext.getUserId(), contestId);
        if (contestEnrollmentDto == null) {
            throw new BadRequestException(messageUtil.get("contest.enrollment.notfound"));
        }
    }
}
