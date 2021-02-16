package com.kablanfatih.company.controller;

import com.kablanfatih.company.repository.CompanyRepository;
import com.kablanfatih.company.service.CompanyService;
import com.kablanfatih.company.util.TPage;
import com.kablanfatih.servicecommon.contract.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kablanfatih.company.util.ApiPaths;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.Company.PATH)
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;
    private final CompanyRepository repository;

    @GetMapping
    public ResponseEntity<TPage<CompanyDto>> getAllByPagination(Pageable pageable) {
        TPage<CompanyDto> data = service.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyDto> save(@Valid @RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(service.save(companyDto));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CompanyDto> update(@PathVariable("id") Long id, @Valid @RequestBody CompanyDto companyDto){
        return ResponseEntity.ok(service.update(id, companyDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
