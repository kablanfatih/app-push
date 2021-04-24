package com.kablanfatih.content.service;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.entity.es.ContentEs;
import com.kablanfatih.content.request.ContentRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentService {

    ContentDto save(ContentRequest contentRequest);

    ContentDto update(String id, ContentDto contentDto);

    ContentDto getById(String id);

    List<ContentDto> getAll(Long companyId, Pageable pageable);

    ContentDto delete(String id);

    Iterable<ContentEs> search(String word, Pageable pageable);

    Iterable<ContentEs> findByTitle(String title, Long companyId);

    Iterable<ContentEs> findByTitleContains(String title, Pageable pageable, Long companyId);

    Boolean sendContent(Long companyId, String contentId);
}
