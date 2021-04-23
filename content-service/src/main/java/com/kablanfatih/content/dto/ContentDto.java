package com.kablanfatih.content.dto;

import lombok.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {

    private String id;

    private String title;

    private String description;

    private String image;

    private Date sendDate;

    private String contentStatus;

    private Long companyId;
}
