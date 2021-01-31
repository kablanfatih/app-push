package com.kablanfatih.company.service.impl;

import com.kablanfatih.company.dto.UserDto;
import com.kablanfatih.company.entity.User;
import com.kablanfatih.company.repository.CompanyRepository;
import com.kablanfatih.company.repository.UserRepository;
import com.kablanfatih.company.service.UserService;
import com.kablanfatih.company.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    public TPage<UserDto> getAllPageable(Long companyId, Pageable pageable) {

        Page<User> data = repository.findAllByCompanyId(companyId, pageable);
        TPage<UserDto> page = new TPage<UserDto>();
        UserDto[] dtos = modelMapper.map(data.getContent(), UserDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public UserDto getById(Long id) {
        return modelMapper.map(repository.findById(id), UserDto.class);
    }

    @Transactional
    @Override
    public UserDto save(UserDto userDto, Long companyId) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setBirthDate(userDto.getBirthDate());
        user.setCity(userDto.getCity());
        user.setDistrict(userDto.getDistrict());
        user.setAppToken(userDto.getAppToken());
        user.setCompany(companyRepository.getOne(companyId));
        user = repository.save(user);
        return modelMapper.map(user, UserDto.class);
    }
}
