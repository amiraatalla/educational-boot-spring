package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateUnitDTO;
import com.amira.educational.system.alemny.Entities.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
    Unit getUnitById(Long id);
    Unit saveUnit(CreateUnitDTO createUnitDTO);
    Unit updateUnit(Long id, CreateUnitDTO createUnitDTO);
    void deleteUnit(Long id);
}
