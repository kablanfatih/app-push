package com.kablanfatih.content.service.impl;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.entity.Content;
import com.kablanfatih.content.entity.ContentStatus;
import com.kablanfatih.content.entity.es.ContentEs;
import com.kablanfatih.content.repository.ContentRepository;
import com.kablanfatih.content.repository.es.ContentElasticRepository;
import com.kablanfatih.content.request.ContentRequest;
import com.kablanfatih.content.service.ContentNotificationService;
import com.kablanfatih.content.service.ContentService;
import com.kablanfatih.servicecommon.client.CompanyServiceClient;
import com.kablanfatih.servicecommon.contract.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository repository;
    private final ContentElasticRepository esRepository;
    private final ModelMapper modelMapper;
    private final CompanyServiceClient companyServiceClient;
    private final ContentNotificationService contentNotificationService;

    @Override
    public ContentDto save(ContentRequest contentRequest) {

        Content content = new Content();
        content.setTitle(contentRequest.getTitle());
        content.setDescription(contentRequest.getDescription());
        content.setImage(contentRequest.getImage());
        content.setSendDate(contentRequest.getSendDate());
        content.setContentStatus(ContentStatus.valueOf(contentRequest.getContentStatus()));
        content.setCompanyId(contentRequest.getCompanyId());
        content = repository.save(content);
        saveEs(content);
        return modelMapper.map(content, ContentDto.class);
    }

    @Override
    public ContentDto update(String id, ContentDto contentDto) {
        Content content = repository.getOne(id);
        content.setTitle(contentDto.getTitle());
        content.setDescription(contentDto.getDescription());
        content.setImage(contentDto.getImage());
        content.setSendDate(contentDto.getSendDate());
        content.setContentStatus(ContentStatus.valueOf(contentDto.getContentStatus()));
        content = repository.save(content);
        updateEs(id, content);

        return modelMapper.map(content, ContentDto.class);
    }

    @Override
    public ContentDto getById(String id) {
        Content content = repository.getOne(id);
        return modelMapper.map(content, ContentDto.class);
    }

    @Override
    public List<ContentDto> getAll(Long companyId, Pageable pageable) {
        Slice<Content> contents = repository.findAllByCompanyId(companyId, pageable);
        return contents
                .stream()
                .map(element -> modelMapper.map(element, ContentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContentDto delete(String id) {
        Content content = repository.getOne(id);
        repository.deleteById(id);
        deleteEs(id);
        return modelMapper.map(content, ContentDto.class);
    }

    public void saveEs(Content content) {
        ContentEs contentEs = ContentEs.builder()
                .id(content.getId())
                .title(content.getTitle())
                .description(content.getDescription())
                .image(content.getImage())
                .sendDate(content.getSendDate())
                .contentStatus(content.getContentStatus().getLabel())
                .companyId(content.getCompanyId())
                .build();

        esRepository.save(contentEs);
    }

    public void updateEs(String id, Content content) {
        ContentEs contentEs = esRepository.findById(id).orElseThrow();
        contentEs.setTitle(content.getTitle());
        contentEs.setDescription(content.getDescription());
        contentEs.setImage(content.getImage());
        contentEs.setSendDate(content.getSendDate());
        contentEs.setContentStatus(content.getContentStatus().getLabel());

        esRepository.save(contentEs);
    }

    public void deleteEs(String id) {
        esRepository.deleteById(id);
    }

    public Iterable<ContentEs> search(String word, Pageable pageable) {
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(word)
                .field("title")
                .field("description")
                .field("contentStatus")
                .type(MultiMatchQueryBuilder.Type.PHRASE_PREFIX);
        return esRepository.search(queryBuilder, pageable);
    }

    @Override
    public Iterable<ContentEs> findByTitle(String title, Long companyId) {
        return esRepository.findByTitleAndCompanyId(title, companyId);
    }

    @Override
    public Iterable<ContentEs> findByTitleContains(String title, Pageable pageable, Long companyId) {
        return esRepository.findByTitleContainsAndCompanyId(title, pageable, companyId);
    }

    @Override
    public Boolean sendContent(Long companyId, String contentId){
        ResponseEntity<CompanyDto> companyDtoResponseEntity = companyServiceClient.getById(companyId);
        String appId = companyDtoResponseEntity.getBody().getAppId();
        Content content = repository.getOne(contentId);
        contentNotificationService.sendToQueue(content, appId);
        return true;
    }
}
