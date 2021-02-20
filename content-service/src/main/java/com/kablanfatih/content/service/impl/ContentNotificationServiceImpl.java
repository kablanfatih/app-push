package com.kablanfatih.content.service.impl;

import com.kablanfatih.content.entity.Content;
import com.kablanfatih.content.service.ContentNotificationService;
import com.kablanfatih.servicecommon.messaging.ContentNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableBinding(Source.class)
public class ContentNotificationServiceImpl implements ContentNotificationService {

    private final Source source;

    @Override
    public void sendToQueue(Content notification, Long companyId) {

        ContentNotification contentNotification = new ContentNotification();
        contentNotification.setCompanyId(companyId);
        contentNotification.setContentId(notification.getId());
        contentNotification.setContentTitle(notification.getTitle());
        source.output().send(MessageBuilder.withPayload(contentNotification).build());
    }
}
