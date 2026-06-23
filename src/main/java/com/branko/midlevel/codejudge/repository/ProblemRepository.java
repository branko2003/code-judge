package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
