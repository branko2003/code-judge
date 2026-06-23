package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.ContestProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContestProblemRepository extends JpaRepository<ContestProblem, Long> {

    @Query("""
    SELECT cp
    FROM ContestProblem cp
    JOIN FETCH cp.contest c
    JOIN FETCH cp.problem p
    WHERE c.id = :contestId
    AND p.id = :problemId
""")
    ContestProblem findByContestIdAndProblemId(
            @Param("contestId") Long contestId,
            @Param("problemId") Long problemId
    );

    List<ContestProblem> findByContest_Id(Long contestId);
}
