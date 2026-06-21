package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.ContestEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestEnrollmentRepository extends JpaRepository<ContestEnrollment, Long> {

    ContestEnrollment findByUser_IdAndContest_Id(String userId, Long contestId);

    List<ContestEnrollment> findByContest_Id(Long contestId);

}
