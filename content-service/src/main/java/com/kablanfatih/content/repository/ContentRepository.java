package com.kablanfatih.content.repository;

import com.kablanfatih.content.entity.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, String> {

    Page<Content> findAllByCompanyId(Long companyId, Pageable pageable);

}
