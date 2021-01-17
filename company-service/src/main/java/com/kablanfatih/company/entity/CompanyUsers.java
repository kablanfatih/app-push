package com.kablanfatih.company.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(of = {"id"})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "company_users")
public class CompanyUsers extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id = UUID.randomUUID().toString();

    @Column(name = "company_id")
    private String companyId = UUID.randomUUID().toString();

    @Column(name = "user_id")
    private String userId = UUID.randomUUID().toString();


}
