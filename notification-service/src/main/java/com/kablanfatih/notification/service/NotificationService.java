package com.kablanfatih.notification.service;

import com.kablanfatih.servicecommon.client.CompanyServiceClient;
import com.kablanfatih.servicecommon.messaging.ContentNotification;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

//@EnableBinding(Sink.class)
@RequiredArgsConstructor
//@ComponentScan("com.kablanfatih")
@Service
public class NotificationService {

    //private final CompanyServiceClient companyServiceClient;
    private final RestTemplate restTemplate;

   /* @StreamListener(Sink.INPUT)
    public void onNotification(ContentNotification notification) {
        ResponseEntity<List<String>> getUsersToken = companyServiceClient.getUsersTokenByAppId(notification.getAppId());

        System.out.println("-----------------------------------------------------------");
        System.out.println("Notification Alındı");
        System.out.println("Notification => " + notification.toString());
        System.out.println("USERSSSSS");
        System.out.println(getUsersToken.getBody());

    }*/

    public String sendNotification() {

        String apiKey = "key=AAAADHucwU0:APA91bHvTs7HC_vmhrYMKhQAbee2WRVKsSP2gMDVIFbDQ-hrp-Okba17JkGvaglHxGJGZSfSAlaAa133jRmHcR6RzEYR2TFBsEMSdBSdRsaGMTgzvNNziw2Yg6dNa_nZsL1gqVRhRgPq";
        String token = "f2zUdQ4rRw6m4-9zo7Y23P:APA91bGmQ5_4MWpnPqNx28Q7dv26ESKJ1IvE2bSrDY7zwPCEs15ZfTpFpF2AnAKgz7GKeSlpmgdlZEQWKqt0qi4tD_x-SgUVunlgU-rdperxm6GuGrzD8dE4TChlAoTZGDg3KrIWad07";
        String token2 = "df6L8D1JRROatqr2KUzbVF:APA91bEuc7ODwS0mbs1egqrla8OUtyoUzGTGfdCR70DDUn9KUwZenxA0SrQwqs3AdcALeoJHJexcBDYqNp3gBue3lWiYAI3BhSA4UnGTE1R7V8Js-PY_46H7y-cFt93mtfXfYWYTW3p9";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", apiKey);

        JSONObject json = new JSONObject();
        json.put("to", token);
        JSONObject info = new JSONObject();
        info.put("title", "APPPUSH");
        info.put("body", "Hello Test notification");
        json.put("notification", info);
        HttpEntity<String> entity = new HttpEntity<>(json.toString(), headers);

        String res = restTemplate.exchange(
                "https://fcm.googleapis.com/fcm/send?channel=apppush", HttpMethod.POST, entity, String.class).getBody();
        System.out.println("Send Notification");
        System.out.println(res);
        return res;
    }

}
