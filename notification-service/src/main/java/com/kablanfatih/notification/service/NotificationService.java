package com.kablanfatih.notification.service;

import com.kablanfatih.servicecommon.client.CompanyServiceClient;
import com.kablanfatih.servicecommon.messaging.ContentNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import java.util.List;

@EnableBinding(Sink.class)
@RequiredArgsConstructor
@ComponentScan("com.kablanfatih")
public class NotificationService {

    private final CompanyServiceClient companyServiceClient;

    @StreamListener(Sink.INPUT)
    public void onNotification(ContentNotification notification) {
        ResponseEntity<List<String>> getUsersToken = companyServiceClient.getUsersTokenByAppId(notification.getAppId());

        System.out.println("-----------------------------------------------------------");
        System.out.println("Notification Alındı");
        System.out.println("Notification => "+notification.toString());
        System.out.println("USERSSSSS");
        System.out.println(getUsersToken.getBody());

    }
}
