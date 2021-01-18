package com.kablanfatih.company.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode(of = {"id"})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "companies")
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "app_id")
    private String appId;

    @JoinColumn(name = "company_users")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<CompanyUsers> companyUsers;
}
