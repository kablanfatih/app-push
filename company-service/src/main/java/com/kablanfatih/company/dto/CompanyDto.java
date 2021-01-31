package com.kablanfatih.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private String id;
    private String name;
    private String address;
    private String appId;
}
