package com.kablanfatih.servicecommon.client;

import com.kablanfatih.servicecommon.contract.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("company-service")
public interface CompanyServiceClient {

    @RequestMapping("/api/company/{companyId}")
    ResponseEntity<CompanyDto> getById(@PathVariable("companyId") Long companyId);

    @GetMapping("api/company/user/token/{appId}")
    ResponseEntity<List<String>> getUsersTokenByAppId(@PathVariable("appId") String appId);
}
