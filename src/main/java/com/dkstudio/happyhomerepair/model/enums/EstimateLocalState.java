package com.dkstudio.happyhomerepair.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstimateLocalState {
    SEOUL(0L,"서울", ""),
    INCHEON(1L,"인천",""),
    GYEONGGI_DO(2L,"경기도","");

    private Long id;
    private String title;
    private String description;
}
