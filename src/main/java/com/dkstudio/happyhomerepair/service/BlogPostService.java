package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.BlogPost;
import com.dkstudio.happyhomerepair.model.entity.BlogPostNotFoundException;
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

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public void createBlogPostList(List<BlogPost> blogPostList) {
        blogPostList.forEach(this::createBlogPost);
    }

    public List<BlogPost> getBlogPostList() {
        return blogPostRepository.findAll();
    }

    public BlogPost updateBlogPost(
            Long blogPostId,
            String title,
            String targetUrl
    ) {
        return blogPostRepository.findById(blogPostId)
                .map(blogPostEntity -> {
                    blogPostEntity
                            .setTitle(title)
                            .setTargetUrl(targetUrl);
                    return blogPostEntity;
                })
                .orElseThrow(() -> new BlogPostNotFoundException(blogPostId));
    }

    public void deleteBlogPost(
            Long blogPostId
    ) {
        blogPostRepository.deleteById(blogPostId);
    }
}
