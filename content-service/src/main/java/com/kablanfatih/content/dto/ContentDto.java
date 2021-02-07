package com.kablanfatih.content.dto;

import com.kablanfatih.content.entity.ContentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {

    private UUID id;

    private String title;

    private String description;

    private String image;

    private String segmentation;

    private Date sendDate;

    private String contentStatus;
}
