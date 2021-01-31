package com.kablanfatih.company.service;

import com.kablanfatih.company.dto.CompanyDto;
import com.kablanfatih.company.util.TPage;
import org.springframework.data.domain.Pageable;

public interface CompanyService {

    CompanyDto save (CompanyDto company);

    TPage<CompanyDto> getAllPageable(Pageable pageable);

    CompanyDto getById(Long id);

    CompanyDto update(Long id, CompanyDto companyDto);

    Boolean delete(Long id);
}
