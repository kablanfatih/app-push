package com.kablanfatih.company.service.impl;

import com.kablanfatih.company.entity.Company;
import com.kablanfatih.company.repository.CompanyRepository;
import com.kablanfatih.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    @Override
    public Company save(Company company) {
        Company a = new Company();
        a.setName(company.getName());
        a.setAddress(company.getAddress());
        a.setAppId(company.getAppId());
        return repository.save(a);
    }
}
