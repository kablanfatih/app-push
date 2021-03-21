package com.kablanfatih.company.service.integration;

import com.kablanfatih.company.entity.Company;
import com.kablanfatih.company.entity.User;
import com.kablanfatih.company.repository.CompanyRepository;
import com.kablanfatih.company.repository.UserRepository;
import com.kablanfatih.company.service.impl.CompanyServiceImpl;
import com.kablanfatih.company.util.TPage;
import com.kablanfatih.servicecommon.contract.CompanyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CompanyServiceImplTest {

    @Autowired
    CompanyServiceImpl service;

    @Autowired
    CompanyRepository repository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSave() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("Company Name");
        companyDto.setAddress("İstanbul");
        companyDto.setAppId("appId123");

        CompanyDto result = service.save(companyDto);
        assertTrue(result.getId() > 0L);
        assertEquals(result.getAppId(), companyDto.getAppId());
    }

    @Test
    public void testGetById() {
        Company company = new Company();
        company.setId(1L);
        company.setName("Company");
        company.setAddress("İstanbul");
        company.setAppId("appId123");
        repository.save(company);
        CompanyDto result = service.getById(1L);
        assertEquals(result.getName(), "Company");
        assertEquals(result.getAppId(), "appId123");
    }

    @Test
    public void testUpdate() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setAddress("İzmir");
        companyDto.setAppId("123APPID");
        CompanyDto result = service.update(2L, companyDto);

        assertEquals(result.getAddress(), companyDto.getAddress());
        assertEquals(result.getAppId(), companyDto.getAppId());
    }

    @Test
    public void testGetAllPageable() {
        Company company = new Company();
        company.setName("Company");
        company.setAddress("İstanbul");
        company.setAppId("appId123");
        repository.save(company);
        PageRequest pageRequest = PageRequest.of(0, 1);
        TPage<CompanyDto> result = service.getAllPageable(pageRequest);
        assertEquals(result.getSize(), 1);
        assertEquals(result.getContent().get(0).getAppId(), "appId123");
    }

    @Test
    public void testGetUsersTokenByAppId() {
        Company company = new Company();
        company.setAppId("MyApp123");
        Company companyDb = repository.save(company);
        User user = new User();
        user.setAppToken("token123");
        user.setCompany(companyDb);
        userRepository.save(user);
        List<String> result = service.getUsersTokenByAppId("MyApp123");
        assertEquals("token123", result.get(0));
    }

    @Test
    public void testDelete() {
        Company company = new Company();
        company.setId(3L);
        company.setName("Company2");
        repository.save(company);
        Boolean result = service.delete(3L);
        assertEquals(result, Boolean.TRUE);
    }
}