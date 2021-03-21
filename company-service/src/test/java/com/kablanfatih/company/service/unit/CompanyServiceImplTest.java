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
    void getAllPageableTest() {

        CompanyDto companyDto2 = new CompanyDto();
        companyDto2.setName("name2");
        companyDto2.setAddress("address2");
        companyDto2.setAppId("qwe123");

        PageRequest pageRequest = PageRequest.of(1, 10);
        List<CompanyDto> data = Arrays.asList(companyDto, companyDto2);
        Page<CompanyDto> page = new PageImpl<>(data);
        TPage<CompanyDto> pages1 = new TPage<>();
        CompanyDto[] dtos = modelMapper.map(page.getContent(), CompanyDto[].class);
        System.out.println("cont: " +page.getContent());
        when(modelMapper.map(any(), any())).thenReturn(dtos);

        System.out.println("dtos: " + dtos);
        pages1.setStat(page, Arrays.asList(dtos));
        when(service.getAllPageable(pageRequest)).thenReturn(pages1);
        TPage<CompanyDto> result = service.getAllPageable(pageRequest);

        assertEquals(result.getContent().get(0).getName(), companyDto.getName());
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

    @Test
    public void testGetUsersTokenByAppId(){
        List<User> users = new ArrayList<>();
        List<String> tokens = new ArrayList<>();
        Company company = new Company();
        users.add(user);
        company.setUsers(users);
        tokens.add(user.getAppToken());

        when(repository.findByAppId(company.getAppId())).thenReturn(company);
        when(service.getUsersTokenByAppId(company.getAppId())).thenReturn(tokens);
        List<String> result = service.getUsersTokenByAppId(company.getAppId());
        System.out.println(result);
        //assertEquals(result.get(0). ,users.get(0).getAppToken());


    }
}