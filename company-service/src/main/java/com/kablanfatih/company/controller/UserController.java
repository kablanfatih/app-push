package com.kablanfatih.company.controller;

import com.kablanfatih.company.dto.UserDto;
import com.kablanfatih.company.service.UserService;
import com.kablanfatih.company.util.ApiPaths;
import com.kablanfatih.company.util.TPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.User.PATH)
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{companyId}")
    public ResponseEntity<TPage<UserDto>> getAllByPagination(@PathVariable(value = "companyId")
                                                                     Long companyId, Pageable pageable) {

        TPage<UserDto> data = service.getAllPageable(companyId ,pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){

        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<UserDto> save(@PathVariable(value = "companyId") Long companyId,
                                        @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.save(userDto, companyId));
    }
}
