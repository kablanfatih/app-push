package com.kablanfatih.company.controller;

import com.kablanfatih.company.entity.Company;
import com.kablanfatih.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kablanfatih.company.util.ApiPaths;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.Company.PATH)
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @PostMapping
    public ResponseEntity<Company> save(@Valid @RequestBody Company company) {

        Company a = new Company();
        a.setName(company.getName());
        a.setAddress(company.getAddress());
        a.setAppId(company.getAppId());
        return ResponseEntity.ok(service.save(a));
    }
}
