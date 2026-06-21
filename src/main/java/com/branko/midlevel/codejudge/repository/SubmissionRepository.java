package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
