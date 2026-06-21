package com.branko.midlevel.codejudge.dto.other;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContestProblemDto {

    private Long id;

    private ContestDto contest;

    private Long problemId;
}
