package com.kablanfatih.content.service;

import com.kablanfatih.content.dto.ContentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContentService {

    ContentDto save(ContentDto contentDto);

    ContentDto update(String id, ContentDto contentDto);

    ContentDto getById(String id);

    Page<ContentDto> getPagination(Pageable pageable);
}
