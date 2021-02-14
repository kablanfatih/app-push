package com.kablanfatih.content.service;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.entity.es.ContentEs;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentService {

    ContentDto save(ContentDto contentDto);

    ContentDto update(String id, ContentDto contentDto);

    ContentDto getById(String id);

    List<ContentDto> getAll(Pageable pageable);

    ContentDto delete(String id);

    Iterable<ContentEs> search(String word, Pageable pageable);

    Iterable<ContentEs> findByTitle(String title);

    Iterable<ContentEs> findByTitleContains(String title, Pageable pageable);
}
