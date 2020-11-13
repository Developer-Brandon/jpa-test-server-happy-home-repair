package com.dkstudio.happyhomerepair.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstimateState {
    PAINT(0L,"친환경페인트", ""),
    FIX_WINDOW(1L,"창호수리,방충망",""),
    DOOR(2L,"문짝,문틀",""),
    MIDDLE_DOOR(3L,"중문,포켓도어",""),
    ETC(4L,"선풍기,선반,건조대","");

    private Long id;
    private String title;
    private String description;
}
