package com.kablanfatih.company.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "app_id", length = 255)
    private String appId;
}
