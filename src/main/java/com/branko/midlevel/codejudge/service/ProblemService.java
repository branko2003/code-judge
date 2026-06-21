package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.repository.entity.Problem;

public interface ProblemService {

    ProblemDto createProblem(Problem problem);

    ProblemDto getById(Long problemId);
}
