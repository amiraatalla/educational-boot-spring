package com.amira.educational.system.alemny.Repositories;

import com.amira.educational.system.alemny.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository  extends JpaRepository<User, Long> {
}
