package com.kablanfatih.notification.service;

import com.kablanfatih.servicecommon.messaging.ContentNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationService {

    @StreamListener(Sink.INPUT)
    public void onNotification(ContentNotification notification) {

        System.out.println("-----------------------------------------------------------");
        System.out.println("Notification Alındı");
        System.out.println("Notification => "+notification.toString());

    }
}
