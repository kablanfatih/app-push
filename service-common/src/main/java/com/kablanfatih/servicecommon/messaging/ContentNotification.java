package com.kablanfatih.servicecommon.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentNotification {

    private String appId;
    private String contentId;
    private String contentTitle;
}
