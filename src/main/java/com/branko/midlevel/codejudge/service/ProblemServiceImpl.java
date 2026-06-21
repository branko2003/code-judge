package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.mapper.ProblemMapper;
import com.branko.midlevel.codejudge.repository.ProblemRepository;
import com.branko.midlevel.codejudge.repository.entity.Problem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;

    @Override
    public ProblemDto createProblem(Problem problem) {
        return problemMapper.problemDtoFromMapProblem(problemRepository.save(problem));
    }

    @Override
    public ProblemDto getById(Long problemId) {
        return problemMapper.problemDtoFromMapProblem(problemRepository.getReferenceById(problemId));
    }
}
