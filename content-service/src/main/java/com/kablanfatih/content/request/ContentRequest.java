package com.kablanfatih.content.request;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class ContentRequest {

    @NotNull(message = "Title is Not Null")
    private String title;

    @Size(max = 3000)
    @NotNull(message = "Description is Not Null")
    private String description;

    @NotNull(message = "Image is Not Null")
    private String image;

    private Date sendDate;

    private String contentStatus;

    @NotNull(message = "Company Id is Not Null")
    private Long companyId;
}
