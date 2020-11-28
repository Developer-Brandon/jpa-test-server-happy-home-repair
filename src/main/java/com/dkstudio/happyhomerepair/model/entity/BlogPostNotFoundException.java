package com.dkstudio.happyhomerepair.model.entity;

public class BlogPostNotFoundException extends RuntimeException{
    public BlogPostNotFoundException(Long id) {
        super("블로그 포스트 ID[" + id + "]에 해당하는 포스트를 찾을 수 없습니다!");
    }
}
