package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;
import com.branko.midlevel.codejudge.dto.request.SubmitSumissionRequest;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    SubmissionDto submissionDtoFromMapSubmission(Submission submission);

    Submission submissionFromMapSubmitSubmissionRequest(SubmitSumissionRequest request);
}
