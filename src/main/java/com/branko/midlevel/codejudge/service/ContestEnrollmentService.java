package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;

import java.util.List;

public interface ContestEnrollmentService {

    void assignUserToContest(Long contestId, String userId);

    ContestEnrollmentDto getByUserIdAndContestId(String userId, Long contestId);

    void assignUserToContestInBulk(Long contestId, List<String> userIds);

    List<ContestEnrollmentDto> getByContestId(Long contestId);

}
