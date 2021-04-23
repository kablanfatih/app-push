package com.kablanfatih.content.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contents")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Content extends Auditable<String> {

    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @Getter
    @Setter
    @Column(name = "description", length = 3000)
    private String description;

    @Getter
    @Setter
    @Column(name = "image")
    private String image;

    @Getter
    @Setter
    @Column(name = "send_date")
    private Date sendDate;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "content_status")
    private ContentStatus contentStatus;

    @Getter
    @Setter
    @Column(name = "company_id",nullable = false)
    private Long companyId;
}
