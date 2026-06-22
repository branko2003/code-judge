package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.ProblemToContestRequest;
import com.branko.midlevel.codejudge.dto.request.CreateProblemRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.dto.response.ProblemResponse;
import com.branko.midlevel.codejudge.usecase.AssignProblemToContestUseCase;
import com.branko.midlevel.codejudge.usecase.CreateProblemUseCase;
import com.branko.midlevel.codejudge.usecase.RemoveProblemToContestUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProblemController {

    private final CreateProblemUseCase createProblemUseCase;
    private final AssignProblemToContestUseCase assignProblemToContestUseCase;
    private final RemoveProblemToContestUseCase removeProblemToContestUseCase;

    @PostMapping("/CreateProblem")
    public ProblemResponse createContest(@Valid @RequestBody CreateProblemRequest request) {
        return createProblemUseCase.execute(request);
    }

    @PostMapping("/AssignProblemToContest")
    public CommonResponse assignProblemsToContest(@Valid @RequestBody ProblemToContestRequest request) {
        return assignProblemToContestUseCase.execute(request);
    }

    @PostMapping("/RemoveProblemToContest")
    public CommonResponse removeProblemsToContest(@Valid @RequestBody ProblemToContestRequest request) {
        return removeProblemToContestUseCase.execute(request);
    }
}
