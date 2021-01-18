package com.kablanfatih.company.service.impl;

import com.kablanfatih.company.dto.UserDto;
import com.kablanfatih.company.entity.CompanyUsers;
import com.kablanfatih.company.entity.User;
import com.kablanfatih.company.repository.CompanyUsersRepository;
import com.kablanfatih.company.repository.UserRepository;
import com.kablanfatih.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final CompanyUsersRepository companyUsersRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public UserDto save(UserDto userDto, Long companyId) {
        System.out.println("dasdas");
        System.out.println(userDto);
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setBirthDate(userDto.getBirthDate());
        user.setCity(userDto.getCity());
        user.setDistrict(userDto.getDistrict());
        user.setAppToken(userDto.getAppToken());
        user = repository.save(user);
        CompanyUsers companyUsers = new CompanyUsers();
        companyUsers.setCompanyId(companyId);
        companyUsers.setUserId(user.getId());
        companyUsersRepository.save(companyUsers);
        return modelMapper.map(user, UserDto.class);
    }
}
