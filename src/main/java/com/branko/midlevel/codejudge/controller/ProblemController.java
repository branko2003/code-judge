package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.CreateProblemRequest;
import com.branko.midlevel.codejudge.dto.response.ProblemResponse;
import com.branko.midlevel.codejudge.usecase.CreateProblemUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProblemController {

    private final CreateProblemUseCase createProblemUseCase;

    @PostMapping("/CreateProblem")
    public ProblemResponse createContest(@Valid @RequestBody CreateProblemRequest request) {
        return createProblemUseCase.execute(request);
    }
}
