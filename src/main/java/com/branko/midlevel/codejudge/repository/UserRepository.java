package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
