package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;
import com.branko.midlevel.codejudge.repository.SubmissionRepository;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;

    @Override
    public SubmissionDto createSubmission(Submission submission) {
        submissionRepository.save(submission);
        return null;
    }
}
