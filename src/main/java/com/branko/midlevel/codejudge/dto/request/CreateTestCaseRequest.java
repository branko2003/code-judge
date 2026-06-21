package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTestCaseRequest {

    @NotNull
    private Long problemId;

    @NotBlank
    private String inputData;

    @NotBlank
    private String expectedOutput;

}
