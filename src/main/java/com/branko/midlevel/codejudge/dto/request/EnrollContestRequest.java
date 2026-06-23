package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class EnrollContestRequest {

    @NotNull(message = "{contestId.notnull}")
    private Long contestId;
}
