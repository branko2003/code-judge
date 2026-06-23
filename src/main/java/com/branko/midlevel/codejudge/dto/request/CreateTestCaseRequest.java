package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTestCaseRequest {

    @NotNull(message = "{problemId.notnull}")
    private Long problemId;

    @NotBlank(message = "{testCaseInputData.notblank}")
    private String inputData;

    @NotBlank(message = "{testCaseExpectedOutput.notblank}")
    private String expectedOutput;
}
