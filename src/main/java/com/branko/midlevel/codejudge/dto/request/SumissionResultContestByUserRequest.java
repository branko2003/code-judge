package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumissionResultContestByUserRequest {

    @NotNull(message = "{contestId.notnull}")
    private Long contestId;

    @NotNull(message = "{userId.notnull}")
    private String userId;
}
