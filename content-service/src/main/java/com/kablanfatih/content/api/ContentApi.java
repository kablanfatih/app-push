package com.kablanfatih.content.api;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.entity.es.ContentEs;
import com.kablanfatih.content.request.ContentRequest;
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

    @GetMapping("pagination/{companyId}")
    public ResponseEntity<List<ContentDto>> getAll(@PathVariable("companyId") Long companyId, Pageable pageable){
        return ResponseEntity.ok(service.getAll(companyId, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDto> getBydId(@PathVariable("id") String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ContentDto> create(@Valid @RequestBody ContentRequest contentRequest){
        return ResponseEntity.ok(service.save(contentRequest));
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

    @GetMapping("title/{companyId}/{title}")
    public ResponseEntity<Iterable<ContentEs>> getByTitle(@PathVariable("title") String title, @PathVariable("companyId") Long companyId){

        return ResponseEntity.ok(service.findByTitle(title, companyId));
    }

    @GetMapping("search/title/{companyId}/{word}")
    public ResponseEntity<Iterable<ContentEs>> getByTitles(@PathVariable("word") String title, @PathVariable("companyId") Long companyId, Pageable pageable){

        return ResponseEntity.ok(service.findByTitleContains(title, pageable, companyId));
    }

    @GetMapping("send/{companyId}/{contentId}")
    public ResponseEntity<Boolean> sendContent(@PathVariable("companyId") Long companyId,
                                                    @PathVariable("contentId") String contentId){
        return ResponseEntity.ok(service.sendContent(companyId,contentId));
    }
}
