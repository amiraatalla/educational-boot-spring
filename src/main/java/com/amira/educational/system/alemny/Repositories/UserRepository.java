package com.amira.educational.system.alemny.Repositories;

import com.amira.educational.system.alemny.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
