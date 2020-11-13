package com.dkstudio.happyhomerepair.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AdminUserState {
    ACTIVE(0L, "활성", "사용자의 계정이 활성화된 상태입니다"),
    INACTIVE(1L, "비활성", "사용자의 계정이 비활성화된 상태입니다");

    private Long id;
    private String title;
    private String description;
}
