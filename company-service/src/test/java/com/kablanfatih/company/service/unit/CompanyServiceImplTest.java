package com.kablanfatih.company.service.unit;

import com.kablanfatih.company.entity.Company;
import com.kablanfatih.company.entity.User;
import com.kablanfatih.company.repository.CompanyRepository;
import com.kablanfatih.company.service.CompanyService;
import com.kablanfatih.company.service.impl.CompanyServiceImpl;
import com.kablanfatih.company.util.TPage;
import com.kablanfatih.servicecommon.contract.CompanyDto;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceImplTest {

    @InjectMocks
    CompanyServiceImpl service;

    @Mock
    CompanyService companyService;

    @Mock
    CompanyRepository repository;

    @Mock
    ModelMapper modelMapper;

    @Mock
    CompanyDto companyDto;

    @Mock
    Company companyMock;

    @Mock
    User user;

    @Before
    public void setup() {
        companyDto = new CompanyDto();
        companyDto.setName("name");
        companyDto.setAddress("address");
        companyDto.setAppId("qwe123");
        companyMock = mock(Company.class);
        user = mock(User.class);


    }


    @Test
    public void testSave() {

        when(modelMapper.map(any(), any())).thenReturn(companyDto);
        when(repository.save(any(Company.class))).thenReturn(companyMock);
        CompanyDto result = service.save(companyDto);
        assertEquals(result.getName(), companyDto.getName());
        assertEquals(result.getAddress(), companyDto.getAddress());
        assertEquals(result.getAppId(), companyDto.getAppId());

    }



    @Test
    public void testUpdate() {

        when(modelMapper.map(any(), any())).thenReturn(companyDto);
        when(repository.getOne(1L)).thenReturn(companyMock);
        CompanyDto result = service.update(1L, companyDto);
        assertEquals(result.getId(), companyDto.getId());
        assertEquals(result.getName(), companyDto.getName());

    }

    @Test
    public void testGetById() {

        when(modelMapper.map(companyMock, CompanyDto.class)).thenReturn(companyDto);
        when(repository.getOne(1L)).thenReturn(companyMock);
        CompanyDto result = service.getById(1L);
        assertEquals(result.getId(), companyDto.getId());
        assertEquals(result.getName(), companyDto.getName());

    }

    @Test
    public void testDelete() {
        Boolean result = service.delete(1L);
        assertEquals(result, Boolean.TRUE);

    }


}