package com.dkstudio.happyhomerepair.model.entity;

public class NoticeNotFoundException extends RuntimeException{
    public NoticeNotFoundException(Long id) {
        super("공지사항 ID[" + id + "]에 해당하는 공지사항을 찾을 수 없습니다!");
    }
}
