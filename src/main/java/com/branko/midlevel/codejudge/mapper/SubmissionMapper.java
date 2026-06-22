package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;
import com.branko.midlevel.codejudge.dto.other.SubmissionUpdate;
import com.branko.midlevel.codejudge.dto.other.SubmissionWithProblemDto;
import com.branko.midlevel.codejudge.dto.request.SubmitSumissionRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateContestRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.repository.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    @Mapping(target = "contestProblemId", expression = "java(submission.getContestProblem().getId())")
    //@Mapping(target = "userId", expression = "java(submission.getUser().getId())")
    SubmissionDto submissionDtoFromMapSubmission(Submission submission);

    @Mapping(target = "user", expression = "java(mapUser(request.getUserId()))")
    @Mapping(target = "contestProblem", expression = "java(mapContestProblem(contestProblemId))")
    Submission submissionFromMapSubmitSubmissionRequest(SubmitSumissionRequest request, Long contestProblemId);

    Submission submissionFromMapSubmissionDto(SubmissionDto submissionDto);

    List<SubmissionDto> submissionDtoListFromMapSubmissionList(List<Submission> submissionList);

    void updateSubmissionFromSubmissionUpdate(SubmissionUpdate submissionUpdate, @MappingTarget Submission submission);

    default User mapUser(String id) {
        User u = new User();
        u.setId(id);
        return u;
    }

    default ContestProblem mapContestProblem(Long id) {
        ContestProblem c = new ContestProblem();
        c.setId(id);
        return c;
    }
}
