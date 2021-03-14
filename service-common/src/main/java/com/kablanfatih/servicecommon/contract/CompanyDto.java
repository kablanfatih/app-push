package com.kablanfatih.servicecommon.contract;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Long id;
    private String name;
    private String address;
    private String appId;
}
