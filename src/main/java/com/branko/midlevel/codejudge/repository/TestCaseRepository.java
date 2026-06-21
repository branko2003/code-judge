package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
