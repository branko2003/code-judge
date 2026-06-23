package com.branko.midlevel.codejudge.service.impl;


import com.branko.midlevel.codejudge.constant.ContestStatusEnum;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.request.UpdateContestRequest;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.ContestMapper;
import com.branko.midlevel.codejudge.repository.ContestRepository;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.service.ContestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContestServiceImpl implements ContestService {

    private final ContestRepository contestRepository;
    private final ContestMapper contestMapper;
    private final MessageUtil messageUtil;

    @Override
    public ContestDto createContest(Contest contest) {
        return contestMapper.contestDtoFromMapContest(contestRepository.save(contest));
    }

    @Override
    public ContestDto getById(Long contestId) {
        return contestMapper.contestDtoFromMapContest(contestRepository.getReferenceById(contestId));
    }

    @Override
    public ContestDto updateContest(UpdateContestRequest request) {
        Contest contest = contestRepository.findById(request.getId())
                .orElseThrow(() -> new BadRequestException(messageUtil.get("contest.notfound")));

        contestMapper.updateContestFromRequest(request, contest);
        Contest updatedContest = contestRepository.save(contest);
        return contestMapper.contestDtoFromMapContest(updatedContest);
    }

    @Override
    @Transactional
    public void closeExpiredContests(LocalDateTime time) {
        contestRepository.closeExpiredContests(time, ContestStatusEnum.DONE.get(), ContestStatusEnum.RUNNING.get());
    }

    @Override
    @Transactional
    public void startContests(LocalDateTime time) {
        contestRepository.startContests(time, ContestStatusEnum.RUNNING.get(), ContestStatusEnum.PENDING.get());
    }
}
