package com.dkstudio.happyhomerepair.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AdminUserRoleState {
    SUPER(0L,"마스터","슈퍼관리자 권한입니다"),
    NORMAL(1L,"일반어드민","일반 어드민 계정입니다");

    private Long id;
    private String title;
    private String description;
}
