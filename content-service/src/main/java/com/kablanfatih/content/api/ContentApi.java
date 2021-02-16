package com.kablanfatih.content.api;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.entity.es.ContentEs;
import com.kablanfatih.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class ContentApi {

    public final ContentService service;

    @GetMapping
    public ResponseEntity<List<ContentDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDto> getBydId(@PathVariable("id") String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<ContentDto> create(@Valid @RequestBody ContentDto contentDto, @PathVariable("companyId") Long companyId){
        return ResponseEntity.ok(service.save(contentDto, companyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentDto> update(@PathVariable("id") String id, @Valid @RequestBody ContentDto contentDto){
        return ResponseEntity.ok(service.update(id, contentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContentDto> delete(@PathVariable("id") String id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("search/{word}")
    public ResponseEntity<Iterable<ContentEs>> search(@PathVariable("word") String word, Pageable pageable){

        return ResponseEntity.ok(service.search(word, pageable));
    }

    @GetMapping("title/{title}")
    public ResponseEntity<Iterable<ContentEs>> getByTitle(@PathVariable("title") String title){

        return ResponseEntity.ok(service.findByTitle(title));
    }

    @GetMapping("search/title/{word}")
    public ResponseEntity<Iterable<ContentEs>> getByTitles(@PathVariable("word") String title, Pageable pageable){

        return ResponseEntity.ok(service.findByTitleContains(title, pageable));
    }
}
