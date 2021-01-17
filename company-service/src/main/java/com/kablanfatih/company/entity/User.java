package com.kablanfatih.company.entity;

import lombok.*;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(of = {"id"})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id = UUID.randomUUID().toString();

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String surname;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "app_token")
    private String appToken;
}
