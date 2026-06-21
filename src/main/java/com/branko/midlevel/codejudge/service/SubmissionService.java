package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import org.springframework.stereotype.Service;

@Service
public interface SubmissionService {

    SubmissionDto createSubmission(Submission submission);
}
