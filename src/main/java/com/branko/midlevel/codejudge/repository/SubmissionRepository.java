package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    List<Submission> findByUserIdAndContestProblemId(String userId, Long contestProblemId);
}
