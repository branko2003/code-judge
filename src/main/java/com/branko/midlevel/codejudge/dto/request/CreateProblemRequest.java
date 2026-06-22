package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateProblemRequest {

    private Long contestId;
    @NotBlank(message = "{problemDescription.notblank}")
    private String description;
    @NotBlank(message = "{problemInputDescription.notblank}")
    private String inputDescription;
    @NotBlank(message = "{problemOutputDescription.notblank}")
    private String outputDescription;
    @NotBlank(message = "{problemSampleInput.notblank}")
    private String sampleInput;
    @NotBlank(message = "{problemSampleOutput.notblank}")
    private String sampleOutput;

}
