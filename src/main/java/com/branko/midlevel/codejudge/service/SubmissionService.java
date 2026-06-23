package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;
import com.branko.midlevel.codejudge.dto.other.SubmissionUpdate;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubmissionService {

    SubmissionDto createSubmission(Submission submission);

    SubmissionDto updateSubmission(Long id, SubmissionUpdate submissionUpdate);

    List<SubmissionDto> getSubmissionByUserIdAndContestProblemId(String userId, Long contestProblemId);
}
