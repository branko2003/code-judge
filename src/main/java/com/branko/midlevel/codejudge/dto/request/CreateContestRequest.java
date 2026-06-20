package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateContestRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;
}
