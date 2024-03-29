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
public class Company extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "app_id", unique = true)
    private String appId;

    @JoinColumn(name = "company")
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> users;
}
