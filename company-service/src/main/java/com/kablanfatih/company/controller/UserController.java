package com.kablanfatih.company.controller;

import com.kablanfatih.company.dto.UserDto;
import com.kablanfatih.company.service.UserService;
import com.kablanfatih.company.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.User.PATH)
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/{id}")
    public ResponseEntity<UserDto> save(@PathVariable(value = "id") Long companyId,
                                        @Valid @RequestBody UserDto userDto) {
        System.out.println(userDto);
        return ResponseEntity.ok(service.save(userDto, companyId));
    }
}
