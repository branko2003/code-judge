package com.branko.midlevel.codejudge.service.async.judge;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;

public interface JudgeServiceAsync {

    void processSubmission(SubmissionDto submissionDto, Long problemId);
}
