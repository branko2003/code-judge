package com.branko.midlevel.codejudge.service.impl;

import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.mapper.ContestEnrollmentMapper;
import com.branko.midlevel.codejudge.repository.ContestEnrollmentRepository;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.repository.entity.ContestEnrollment;
import com.branko.midlevel.codejudge.repository.entity.User;
import com.branko.midlevel.codejudge.service.ContestEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContestEnrollmentServiceImpl implements ContestEnrollmentService {

    private final ContestEnrollmentRepository contestEnrollmentRepository;
    private final ContestEnrollmentMapper contestEnrollmentMapper;

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "contestEnrollmentUser", key = "{#userId, #contestId.toString()}"),
            @CacheEvict(cacheNames = "contestEnrollment", key = "#contestId.toString()")
    })
    public void assignUserToContest(Long contestId, String userId) {
        contestEnrollmentRepository.save(buildContestEnrollment(contestId, userId));
    }

    @Override
    @Cacheable(cacheNames = "contestEnrollmentUser", key = "{#userId, #contestId.toString()}")
    public ContestEnrollmentDto getByUserIdAndContestId(String userId, Long contestId) {
        return contestEnrollmentMapper.contestEnrollemntDtoFromMapcontestEnrollemnt(contestEnrollmentRepository.findByUser_IdAndContest_Id(userId, contestId));
    }

    @Override
    @CacheEvict(cacheNames = "contestEnrollment", key = "{#contestId.toString()}")
    public void assignUserToContestInBulk(Long contestId, List<String> userIds) {
        List<ContestEnrollment> enrollments = userIds.stream()
                .map(userId -> buildContestEnrollment(contestId, userId))
                .toList();

        contestEnrollmentRepository.saveAll(enrollments);
    }

    @Override
    @Cacheable(cacheNames = "contestEnrollment", key = "{#contestId.toString()}")
    public List<ContestEnrollmentDto> getByContestId(Long contestId) {
        return contestEnrollmentMapper.contestEnrollemntListFromMapContestEnrollemntList(contestEnrollmentRepository.findByContest_Id(contestId));
    }

    private ContestEnrollment buildContestEnrollment(Long contestId, String userId) {
        ContestEnrollment contestEnrollment = new ContestEnrollment();
        Contest contest = new Contest();
        contest.setId(contestId);
        User user = new User();
        user.setId(userId);
        contestEnrollment.setUser(user);
        contestEnrollment.setContest(contest);
        return contestEnrollment;
    }
}
