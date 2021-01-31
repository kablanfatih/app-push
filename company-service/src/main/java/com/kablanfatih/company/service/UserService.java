package com.kablanfatih.company.service;

import com.kablanfatih.company.dto.UserDto;
import com.kablanfatih.company.util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user, Long companyId);

    TPage<UserDto> getAllPageable(Long companyId, Pageable pageable);

    UserDto getById(Long id);
}
