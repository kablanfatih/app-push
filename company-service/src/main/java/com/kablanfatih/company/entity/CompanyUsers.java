package com.kablanfatih.company.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@EqualsAndHashCode(of = {"id"})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "company_users")
public class CompanyUsers implements Serializable {

   public CompanyUsers(Long companyId, Long userId){
       this.companyId = companyId;
       this.userId = userId;
   }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    @Setter
    private Long companyId;

    @Column(name = "user_id")
    @Setter
    private Long userId;

    @JoinColumn(name = "companies")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Company> companies;

    @JoinColumn(name = "users")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
}
