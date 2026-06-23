package com.branko.midlevel.codejudge.service.impl;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;
import com.branko.midlevel.codejudge.dto.other.SubmissionUpdate;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.SubmissionMapper;
import com.branko.midlevel.codejudge.repository.SubmissionRepository;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import com.branko.midlevel.codejudge.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper submissionMapper;
    private final MessageUtil messageUtil;

    @Override
    public SubmissionDto createSubmission(Submission submission) {
        return submissionMapper.submissionDtoFromMapSubmission(submissionRepository.save(submission));
    }

    @Override
    public SubmissionDto updateSubmission(Long id, SubmissionUpdate submissionUpdate) {
        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(messageUtil.get("submission.notfound")));
        submissionMapper.updateSubmissionFromSubmissionUpdate(submissionUpdate, submission);
        Submission updatedSubmission  = submissionRepository.save(submission);
        return submissionMapper.submissionDtoFromMapSubmission(updatedSubmission );
    }

    @Override
    public List<SubmissionDto> getSubmissionByUserIdAndContestProblemId(String userId, Long contestProblemId) {
        return submissionMapper.submissionDtoListFromMapSubmissionList(submissionRepository.findByUserIdAndContestProblemId(userId, contestProblemId));
    }
}
