package com.branko.midlevel.codejudge.service;


import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.mapper.ContestMapper;
import com.branko.midlevel.codejudge.repository.ContestRepository;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContestServiceImpl implements ContestService {

    private final ContestRepository contestRepository;
    private final ContestMapper contestMapper;

    @Override
    public ContestDto createContest(Contest contest) {
        return contestMapper.contestDtoFromMapContest(contestRepository.save(contest));
    }

    @Override
    public ContestDto getById(Long contestId) {
        return contestMapper.contestDtoFromMapContest(contestRepository.getReferenceById(contestId));
    }


    /*
    public ContestDto updateContest(Long contestId, Long requesterId, UpdateContestRequest req) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new ContestNotFoundException(contestId));

        if (!contest.getAdminIds().contains(requesterId)) {
            throw new UnauthorizedActionException("Solo los administradores del concurso pueden editarlo");
        }

        contest.updateDetails(req.title(), req.description(), req.startTime(), req.endTime());
        contestRepository.save(contest);
    }
    */
}
