package com.dkstudio.happyhomerepair.model.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class BlogPostTests {
    @Test
    public void 블로그_포스트_생성_테스트() {
        BlogPost blogPost = BlogPost.builder()
                .title("중문")
                .imageUrl("https://blogthumb.pstatic.net/MjAyMDA4MDdfMTY3/MDAxNTk2Nzg4NjIyMTM4.PJ9jgg05AmJh9PWIBAXPBm7smunuHkAq2Quj8AskKbYg.NjfpRIcmNRFivzuWENlpyFAa6wh5q33OSBKuhuoRT38g.JPEG.lain4444/20200806_154153.jpg?type=s2")
                .targetUrl("https://blog.naver.com/PostView.nhn?blogId=lain4444&logNo=222054100175&redirect=Dlog")
                .build();
        assertNotNull(blogPost);
        assertThat(blogPost.getTitle(), is("중문"));
    }
}
