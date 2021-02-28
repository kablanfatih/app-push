package com.kablanfatih.notification.api;

import com.kablanfatih.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifi")
public class NotifiApi {

    public final NotificationService service;

    @GetMapping
    public ResponseEntity<String> getAll(){
        return ResponseEntity.ok(service.sendNotification());
    }
}
