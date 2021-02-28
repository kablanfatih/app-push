package com.kablanfatih.company.service;

import com.kablanfatih.company.util.TPage;
import com.kablanfatih.servicecommon.contract.CompanyDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    CompanyDto save (CompanyDto company);

    TPage<CompanyDto> getAllPageable(Pageable pageable);

    CompanyDto getById(Long id);

    CompanyDto update(Long id, CompanyDto companyDto);

    Boolean delete(Long id);

    List<String> getUsersTokenByAppId(String appId);
}
