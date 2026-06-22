package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProblemToContestRequest {
    @NotNull(message = "{contestId.notnull}")
    private Long contestId;
    @NotNull(message = "{problemId.notnull}")
    private Long problemId;
}
