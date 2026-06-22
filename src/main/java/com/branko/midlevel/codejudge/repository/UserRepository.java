package com.branko.midlevel.codejudge.repository;

import com.branko.midlevel.codejudge.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByIdIn(List<String> ids);

}
