package com.amira.educational.system.alemny.Controllers;

import com.amira.educational.system.alemny.Dtos.CreateUnitDTO;
import com.amira.educational.system.alemny.Dtos.UpdateUnitDTO;
import com.amira.educational.system.alemny.Entities.Unit;
import com.amira.educational.system.alemny.Services.UnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    private final UnitService UnitService;

    // Constructor-based Dependency Injection
    public UnitController(UnitService UnitService) {
        this.UnitService = UnitService;
    }

    @GetMapping("/get-all")
    public List<Unit> getAllUnits() {
        return UnitService.getAllUnits();
    }

    @GetMapping("/get-by-id/{id}")
    public Unit getUnitById(@PathVariable Long id) {
        return UnitService.getUnitById(id);
    }

    @PostMapping("/add-unit")
    public Unit addUnit(@RequestBody CreateUnitDTO CreateUnitDTO) {
        return UnitService.saveUnit(CreateUnitDTO);
    }

    @PatchMapping("/update-unit/{id}")
    public Unit updateUnit(@PathVariable Long id, @RequestBody UpdateUnitDTO updateUnitDTO) {
        return UnitService.updateUnit(id, updateUnitDTO);

    }

    @DeleteMapping("/delete-unit/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        UnitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }
}
