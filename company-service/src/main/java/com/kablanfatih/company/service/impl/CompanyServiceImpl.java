package com.kablanfatih.company.service.impl;

import com.kablanfatih.company.dto.CompanyDto;
import com.kablanfatih.company.entity.Company;
import com.kablanfatih.company.repository.CompanyRepository;
import com.kablanfatih.company.service.CompanyService;
import com.kablanfatih.company.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public TPage<CompanyDto> getAllPageable(Pageable pageable) {
        Page<Company> data = repository.findAll(pageable);
        TPage<CompanyDto> page = new TPage<CompanyDto>();
        CompanyDto[] dtos = modelMapper.map(data.getContent(), CompanyDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    @Transactional
    public CompanyDto getById(Long id) {
        Company company = repository.getOne(id);
        System.out.println("company");
        System.out.println(company);
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    @Transactional
    public CompanyDto save(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());
        company.setAppId(companyDto.getAppId());
        repository.save(company);
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public CompanyDto update(Long id, CompanyDto companyDto) {
        Company company = repository.getOne(id);
        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());
        company.setAppId(companyDto.getAppId());
        repository.save(company);
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return Boolean.TRUE;
    }
}