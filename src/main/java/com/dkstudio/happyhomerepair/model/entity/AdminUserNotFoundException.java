package com.dkstudio.happyhomerepair.model.entity;

public class AdminUserNotFoundException extends RuntimeException{
    public AdminUserNotFoundException(Long id) {
        super("어드민 ID[" + id + "]에 해당하는 유저를 찾을 수 없습니다!");
    }
}
