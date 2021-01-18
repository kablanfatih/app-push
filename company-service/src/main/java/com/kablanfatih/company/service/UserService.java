package com.kablanfatih.company.service;

import com.kablanfatih.company.dto.UserDto;

public interface UserService {

    UserDto save(UserDto user, Long companyId);
}
