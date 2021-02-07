package com.kablanfatih.content.service.impl;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.service.ContentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ContentServiceImpl implements ContentService {
    @Override
    public ContentDto save(ContentDto contentDto) {
        return null;
    }

    @Override
    public ContentDto update(String id ,ContentDto contentDto) {
        return null;
    }

    @Override
    public ContentDto getById(String id) {
        return null;
    }

    @Override
    public Page<ContentDto> getPagination(Pageable pageable) {
        return null;
    }
}
