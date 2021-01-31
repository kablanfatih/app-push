package com.kablanfatih.company.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "status")
    private Boolean status;
}
