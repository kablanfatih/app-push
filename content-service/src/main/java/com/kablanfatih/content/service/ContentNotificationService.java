package com.kablanfatih.content.service;

import com.kablanfatih.content.entity.Content;

public interface ContentNotificationService {

    void sendToQueue(Content notification, String appId);
}
