package com.branko.midlevel.codejudge.usecase.usercontest;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.AddUsersToContestRequest;
import com.branko.midlevel.codejudge.dto.response.AddUsersToContestResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.service.ContestEnrollmentService;
import com.branko.midlevel.codejudge.service.ContestService;
import com.branko.midlevel.codejudge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AddUsersToContestUseCase {

    private final ContestService contestService;
    private final ContestEnrollmentService contestEnrollmentService;
    private final UserService userService;
    private final MessageUtil messageUtil;

    public AddUsersToContestResponse execute(AddUsersToContestRequest request) {
        List<String> usersToInserts = this.validate(request);
        contestEnrollmentService.assignUserToContestInBulk(request.getContestId(), usersToInserts);
        return new AddUsersToContestResponse();
    }

    private List<String> validate(AddUsersToContestRequest request) {
        ContestDto contest = contestService.getById(request.getContestId());
        if (contest == null) {
            throw new BadRequestException(messageUtil.get("contest.notfound"));
        }

        Set<String> userIdList = userService.getUsersByIds(request.getUserList())
                .stream()
                .map(UserDto::getId)
                .collect(Collectors.toSet());
        Set<String> alreadyEnrolled = contestEnrollmentService.getByContestId(request.getContestId())
                .stream()
                .map(ContestEnrollmentDto::getUserId)
                .collect(Collectors.toSet());
        List<String> usersToInsert = userIdList.stream()
                .filter(userId -> !alreadyEnrolled.contains(userId))
                .toList();
        if (usersToInsert.isEmpty()) {
            throw new BadRequestException(messageUtil.get("contest.enrollment.users.nothing.to.add"));
        }

        return usersToInsert;
    }
}
