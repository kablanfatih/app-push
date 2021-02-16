package com.kablanfatih.company.dto;

import com.kablanfatih.servicecommon.contract.CompanyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private String city;
    private String district;
    private String appToken;
    private CompanyDto company;
}
