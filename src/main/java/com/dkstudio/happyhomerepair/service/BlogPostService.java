package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.BlogPost;
import com.dkstudio.happyhomerepair.repository.BlogPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BlogPostService {

    private BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    // TODO: 개별 블로그 포스트 등록
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    // TODO: 블로그 포스트에 해당하는 목록들 등록
    public List<BlogPost> createBlogPostList(List<BlogPost> blogPostList) {
        return null;
    }

    // TODO: 블로그 포슽에 해당하는 목록들 조회(개별조회는 필요없음)
    public List<BlogPost> getBlogPostList() {
        return null;
    }

    // TODO: 개별 블로그 포스트 수정
    public BlogPost updateBlogPost(BlogPost blogPost) {
        return null;
    }

    // TODO: 블로그 포스트에 해당하는 목록들 삭제
    public BlogPost deleteBlogPost(BlogPost blogPost) {
        return null;
    }
}
