package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumissionResultRequest {

    @NotNull(message = "{problemId.notnull}")
    private Long problemId;

    @NotNull(message = "{contestId.notnull}")
    private Long contestId;
}
