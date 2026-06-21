package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.AddUsersToContestRequest;
import com.branko.midlevel.codejudge.dto.request.EnrollContestRequest;
import com.branko.midlevel.codejudge.dto.response.AddUsersToContestResponse;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.repository.entity.ContestEnrollment;
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

    public CommonResponse execute(EnrollContestRequest request) {
        ContestDto contest = this.validate(request);
        UserDto userDto = userService.getById(UserContext.getUserId());
        contestEnrollmentService.assignUserToContest(contest.getId(), userDto.getId());
        return new CommonResponse();
    }

    private ContestDto validate(EnrollContestRequest request) {
        ContestDto contest = contestService.getById(request.getContestId());
        if (contest == null) {
            throw new RuntimeException("");
        }
        return contest;
    }
}
