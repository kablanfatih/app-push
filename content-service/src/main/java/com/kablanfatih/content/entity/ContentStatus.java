package com.kablanfatih.content.entity;

import lombok.Getter;

public enum ContentStatus {

    DRAFT("TASLAK"),
    CREATED("OLUŞTURULDU"),
    APPROVED("ONAYLANDI"),
    IN_PROGRESS("GÖNDERİLİYOR"),
    COMPLETED("TAMAMLANDI");

    @Getter
    private String label;

    ContentStatus(String label){
        this.label = label;
    }
}
