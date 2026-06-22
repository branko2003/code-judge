package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.SubmissionResultDto;
import com.branko.midlevel.codejudge.mapper.SubmissionResultMapper;
import com.branko.midlevel.codejudge.repository.SubmissionResultRepository;
import com.branko.midlevel.codejudge.repository.entity.SubmissionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionResultServiceImpl implements SubmissionResultService {

    private final SubmissionResultRepository submissionResultRepository;
    private final SubmissionResultMapper submissionResultMapper;

    @Override
    public void createSubmissionResult(SubmissionResult submissionResult) {
        submissionResultRepository.save(submissionResult);
    }

    @Override
    public List<SubmissionResultDto> getResultBySubmissionId(Long id) {
        return submissionResultMapper.submissionResultDtoListFromMapSubmissionResultList(submissionResultRepository.findBySubmissionId(id));
    }
}
