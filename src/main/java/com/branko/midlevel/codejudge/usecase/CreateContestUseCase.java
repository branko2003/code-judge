package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.request.CreateContestRequest;
import com.branko.midlevel.codejudge.dto.response.ContestResponse;
import com.branko.midlevel.codejudge.mapper.ContestMapper;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.service.ContestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateContestUseCase {

    private final ContestService contestService;
    private final ContestMapper contestMapper;

    public ContestResponse execute(CreateContestRequest request) {
        this.validate(request);
        Contest contest = contestMapper.contestFromMapCreateContestRequest(request);
        ContestDto contestInset = contestService.createContest(contest);
        return new ContestResponse(contestInset);
    }

    private void validate(CreateContestRequest request) {
        if (!request.getEndTime().isAfter(request.getStartTime())) {
            throw new RuntimeException("");
        }
    }
}
