package com.branko.midlevel.codejudge.dto.other;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContestEnrollmentDto {
    private Long id;
    private Long contestId;
    private String userId;
}
