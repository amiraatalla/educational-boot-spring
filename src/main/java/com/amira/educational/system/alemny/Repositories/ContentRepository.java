package com.amira.educational.system.alemny.Repositories;

import com.amira.educational.system.alemny.Entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
}
