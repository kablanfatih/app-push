package com.kablanfatih.content.repository.es;

import com.kablanfatih.content.entity.es.ContentEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ContentElasticRepository extends ElasticsearchRepository<ContentEs, String> {

    Iterable<ContentEs> findByTitleAndCompanyId(String title, Long companyId);

    Page<ContentEs> findByTitleContainsAndCompanyId(String title, Pageable pageable, Long companyId);

}
