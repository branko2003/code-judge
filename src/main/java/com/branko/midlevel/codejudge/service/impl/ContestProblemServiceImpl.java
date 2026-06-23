package com.branko.midlevel.codejudge.service.impl;

import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.dto.other.ContestProblemWithContest;
import com.branko.midlevel.codejudge.mapper.ContestProblemMapper;
import com.branko.midlevel.codejudge.repository.ContestProblemRepository;
import com.branko.midlevel.codejudge.service.ContestProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContestProblemServiceImpl implements ContestProblemService {

    private final ContestProblemRepository contestProblemRepository;
    private final ContestProblemMapper contestProblemMapper;

    @Override
    public void createContestProblem(Long contestId, Long problemId) {
        contestProblemRepository.save(contestProblemMapper.contestProblemFromMapcontestIdAndProblemId(contestId, problemId));
    }

    @Override
    public ContestProblemDto findByProblemIdAndContestId(Long problemId, Long contestId) {
        return contestProblemMapper.contestProblemDtoFromMapContestProblem(contestProblemRepository.findByContestIdAndProblemId(contestId, problemId));
    }

    @Override
    public ContestProblemWithContest findByProblemIdAndContestIdJoinContest(Long problemId, Long contestId) {
        return contestProblemMapper.contestProblemWithContestFromMapContestProblem(contestProblemRepository.findByContestIdAndProblemId(contestId, problemId));
    }

    @Override
    public void removeContestProblem(Long id) {
        contestProblemRepository.deleteById(id);
    }

    @Override
    public List<ContestProblemDto> findByContestId(Long contestId) {
        return contestProblemMapper.contestProblemDtoListFromMapContestProblemList(contestProblemRepository.findByContest_Id(contestId));
    }
}
