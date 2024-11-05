package com.amira.educational.system.alemny.Repositories;

import com.amira.educational.system.alemny.Entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
