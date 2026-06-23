package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateContestRequest {

    @NotBlank(message = "{contestTitle.notblank}")
    private String title;

    @NotBlank(message = "{contestDescription.notblank}")
    private String description;

    @NotNull(message = "{contestStartTime.notnull}")
    private LocalDateTime startTime;

    @NotNull(message = "{contestEndTime.notnull}")
    private LocalDateTime endTime;
}
