package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.SubmissionResultDto;
import com.branko.midlevel.codejudge.repository.entity.SubmissionResult;

import java.util.List;

public interface SubmissionResultService {

    void createSubmissionResult(SubmissionResult submissionResult);

    List<SubmissionResultDto> getResultBySubmissionId(Long submissionId);

}
