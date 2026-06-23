package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.SubmissionResultDto;
import com.branko.midlevel.codejudge.repository.entity.SubmissionResult;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubmissionResultMapper {

    SubmissionResultDto submissionResultDtoFromMapSubmissionResult(SubmissionResult submissionResult);

    List<SubmissionResultDto> submissionResultDtoListFromMapSubmissionResultList(List<SubmissionResult> submissionResultList);
}
