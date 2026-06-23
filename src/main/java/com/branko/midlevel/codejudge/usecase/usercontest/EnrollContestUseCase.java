package com.branko.midlevel.codejudge.usecase.usercontest;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.EnrollContestRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.service.ContestEnrollmentService;
import com.branko.midlevel.codejudge.service.ContestService;
import com.branko.midlevel.codejudge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollContestUseCase {

    private final ContestService contestService;
    private final ContestEnrollmentService contestEnrollmentService;
    private final UserService userService;
    private final MessageUtil messageUtil;

    public CommonResponse execute(EnrollContestRequest request) {
        UserDto userDto = this.validateUser(request);
        ContestDto contest = this.validateContest(request);
        contestEnrollmentService.assignUserToContest(contest.getId(), userDto.getId());
        return new CommonResponse();
    }

    private ContestDto validateContest(EnrollContestRequest request) {
        ContestDto contest = contestService.getById(request.getContestId());
        if (contest == null) {
            throw new BadRequestException(messageUtil.get("contest.notfound"));
        }
        ContestEnrollmentDto contestEnrollmentDto = contestEnrollmentService.getByUserIdAndContestId(UserContext.getUserId(), contest.getId());
        if (contestEnrollmentDto != null) {
            throw new BadRequestException(messageUtil.get("contest.enrollment.already.exists"));
        }
        return contest;
    }

    private UserDto validateUser(EnrollContestRequest request) {
        UserDto userDto = userService.getById(UserContext.getUserId());
        if (userDto == null) {
            throw new BadRequestException(messageUtil.get("user.notfound"));
        }
        return userDto;
    }
}
