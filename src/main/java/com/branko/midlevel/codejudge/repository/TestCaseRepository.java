package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findByProblemId(Long problemId);

}
