package com.kablanfatih.company.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@EqualsAndHashCode(of = {"id"})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users", indexes = {@Index(name = "idx_email", columnList = "email")})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "app_token")
    private String appToken;

    @JoinColumn(name = "company_users")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<CompanyUsers> companyUsers;
}
