package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ContestRepository extends JpaRepository<Contest, Long> {

    @Modifying
    @Query("""
        UPDATE Contest c
        SET c.status = :status
        WHERE c.status = :current
        AND c.endTime <= :now
    """)
    void closeExpiredContests(@Param("now") LocalDateTime now,
                              @Param("status") String status,
                              @Param("current") String current);

    @Modifying
    @Query("""
    UPDATE Contest c
    SET c.status = :status
    WHERE c.status = :current
    AND c.startTime <= :now
""")
    void startContests(@Param("now") LocalDateTime now,
                       @Param("status") String status,
                       @Param("current") String current);
}
