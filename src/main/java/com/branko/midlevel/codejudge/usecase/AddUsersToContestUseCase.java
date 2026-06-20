package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.request.AddUsersToContestRequest;
import com.branko.midlevel.codejudge.dto.response.AddUsersToContestResponse;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.service.ContestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddUsersToContestUseCase {

    private final ContestService contestService;

    public AddUsersToContestResponse execute(AddUsersToContestRequest request) {
        ContestDto contest = this.validate(request);
        /*if () {

        }*/
        return new AddUsersToContestResponse();
    }

    private ContestDto validate(AddUsersToContestRequest request) {
        ContestDto contest = contestService.getById(request.getContestId());
        if (contest == null) {
            throw new RuntimeException("");
        }
        return contest;
    }
}
