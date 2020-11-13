package com.dkstudio.happyhomerepair.model.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class NoticeTests {
    @Test
    public void 공지_생성_테스트() {
        Notice notice = Notice.builder()
                .title("첫번째 공지사항 제목입니다.")
                .content("첫번째 공지사항 내용입니다.")
                .build();
        assertNotNull(notice);
        assertThat(notice.getTitle(), is("첫번째 공지사항 제목입니다."));
    }
}
