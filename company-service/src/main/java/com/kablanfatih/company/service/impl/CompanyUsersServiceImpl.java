package com.kablanfatih.company.service.impl;

import com.kablanfatih.company.entity.CompanyUsers;
import com.kablanfatih.company.repository.CompanyUsersRepository;
import com.kablanfatih.company.service.CompanyUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyUsersServiceImpl implements CompanyUsersService {

    private final CompanyUsersRepository repository;

    @Override
    public CompanyUsers companyUsers(CompanyUsers companyUsers) {
        CompanyUsers companyUsers1 = new CompanyUsers(companyUsers.getCompanyId(), companyUsers.getUserId());
        return repository.save(companyUsers1);
    }
}
