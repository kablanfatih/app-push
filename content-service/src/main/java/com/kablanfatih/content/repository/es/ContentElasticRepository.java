package com.kablanfatih.content.repository.es;

import com.kablanfatih.content.entity.es.ContentEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ContentElasticRepository extends ElasticsearchRepository<ContentEs, String> {
}
