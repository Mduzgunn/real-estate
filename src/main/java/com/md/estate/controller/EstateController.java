package com.md.estate.controller;

import com.md.estate.dto.EstateDto;
import com.md.estate.dto.request.CreateEstateRequest;
import com.md.estate.dto.request.EstateSearchRequest;
import com.md.estate.dto.request.UpdateEstateRequest;
import com.md.estate.model.Estate;
import com.md.estate.model.EstateType;
import com.md.estate.service.EstateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/estate")
public class EstateController {
    private final EstateService estateService;

    public EstateController(EstateService estateService) {
        this.estateService = estateService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstateDto> getEstateById(@PathVariable Long id) {
        EstateDto estateDto = estateService.getEstateById(id);
        return ResponseEntity.ok(estateDto);
    }

    @GetMapping
    public ResponseEntity<List<EstateDto>> getAllEstates() {
        List<EstateDto> estateDtoList = estateService.getAllEstateDtoList();
        return ResponseEntity.ok(estateDtoList);
    }

    @PostMapping
    public ResponseEntity<EstateDto> createEstate(@RequestBody CreateEstateRequest createEstateRequest) {
        return ResponseEntity.ok(estateService.createEstate(createEstateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstateDto> updateEstate(@PathVariable Long id, @RequestBody UpdateEstateRequest updateEstateRequest) {
        return ResponseEntity.ok(estateService.updateEstate(id, updateEstateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstateById(@PathVariable Long id) {
        return ResponseEntity.ok(estateService.deleteEstateById(id));
    }

    @GetMapping("/type/{estateType}")
    public List<Estate> findEstatesByType(@PathVariable("estateType") EstateType estateType) {
        return estateService.findEstatesByType(estateType);
    }

    @GetMapping("/search")
    public List<Estate> search(EstateSearchRequest estateSearchRequest) {
        return estateService.search(estateSearchRequest);
    }
}
