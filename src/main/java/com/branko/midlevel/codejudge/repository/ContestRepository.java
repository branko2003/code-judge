package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Long> {
}
