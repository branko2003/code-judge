package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.AddUsersToContestRequest;
import com.branko.midlevel.codejudge.dto.request.CreateContestRequest;
import com.branko.midlevel.codejudge.dto.request.EnrollContestRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateContestRequest;
import com.branko.midlevel.codejudge.dto.response.AddUsersToContestResponse;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.dto.response.ContestResponse;
import com.branko.midlevel.codejudge.usecase.usercontest.AddUsersToContestUseCase;
import com.branko.midlevel.codejudge.usecase.contest.CreateContestUseCase;
import com.branko.midlevel.codejudge.usecase.usercontest.EnrollContestUseCase;
import com.branko.midlevel.codejudge.usecase.contest.UpdateContestUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContestController {

    private final CreateContestUseCase createContestUseCase;
    private final AddUsersToContestUseCase addUsersToContestUseCase;
    private final UpdateContestUseCase updateContestUseCase;
    private final EnrollContestUseCase enrollContestUseCase;

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/CreateContest")
    public ContestResponse createContest(@Valid @RequestBody CreateContestRequest request) {
        return createContestUseCase.execute(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/UpdateContest")
    public ContestResponse updateContest(@Valid @RequestBody UpdateContestRequest request) {
        return updateContestUseCase.execute(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/AddUsersToContest")
    public AddUsersToContestResponse addUsersToContest(@Valid @RequestBody AddUsersToContestRequest request) {
        return addUsersToContestUseCase.execute(request);
    }

    @PostMapping("/EnrollContest")
    public CommonResponse enrollContest(@Valid @RequestBody EnrollContestRequest request) {
        return enrollContestUseCase.execute(request);
    }
}
