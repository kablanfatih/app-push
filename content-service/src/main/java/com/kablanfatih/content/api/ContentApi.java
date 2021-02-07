package com.kablanfatih.content.api;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.entity.Content;
import com.kablanfatih.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentApi {

    ContentService service;

    @GetMapping
    public ResponseEntity<Page<ContentDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(service.getPagination(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDto> getBydId(@PathVariable("id") String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ContentDto> create(@Valid @RequestBody ContentDto contentDto){
        return ResponseEntity.ok(service.save(contentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentDto> update(@PathVariable("id") String id, @Valid @RequestBody ContentDto contentDto){
        return ResponseEntity.ok(service.update(id, contentDto));
    }
}
