package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SubmitSumissionRequest {

    @NotNull
    private Long problemId;

    @NotNull
    private Long contestId;

    @NotNull
    private String sourceCode;

    @NotNull
    private String language;
}
