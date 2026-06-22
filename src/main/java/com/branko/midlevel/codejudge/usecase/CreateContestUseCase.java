package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.CreateContestRequest;
import com.branko.midlevel.codejudge.dto.response.ContestResponse;
import com.branko.midlevel.codejudge.mapper.ContestMapper;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.repository.entity.User;
import com.branko.midlevel.codejudge.service.ContestEnrollmentService;
import com.branko.midlevel.codejudge.service.ContestService;
import com.branko.midlevel.codejudge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateContestUseCase {

    private final ContestService contestService;
    private final UserService userService;
    private final ContestMapper contestMapper;
    private final UserMapper userMapper;
    private final ContestEnrollmentService contestEnrollmentService;

    public ContestResponse execute(CreateContestRequest request) {
        String userId = UserContext.getUserId();
        UserDto user = this.validate(request, userId);
        Contest contest = contestMapper.contestFromMapCreateContestRequest(request);
        contest.setCreator(userMapper.userFromUserDto(user));
        ContestDto contestInset = contestService.createContest(contest);
        contestEnrollmentService.assignUserToContest(contestInset.getId(), userId);
        return new ContestResponse(contestInset);
    }

    private UserDto validate(CreateContestRequest request, String userId) {
        UserDto user = userService.getById(userId);
        if (user == null) {
            throw new RuntimeException("");
        }

        //TODO: implementar rol
        if (!request.getEndTime().isAfter(request.getStartTime())) {
            throw new RuntimeException("");
        }
        return user;
    }
}
