package com.branko.midlevel.codejudge.dto.request;

import lombok.Getter;

@Getter
public class CreateProblemRequest {

    private Long contestId;
    private String description;
    private String inputDescription;
    private String outputDescription;
    private String sampleInput;
    private String sampleOutput;

}
