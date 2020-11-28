package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.repository.NoticeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NoticeServiceTests {

    private NoticeService noticeService;

    @Mock
    private NoticeRepository noticeRepository;

    @Before
    public void 초기화() {
        MockitoAnnotations.initMocks(this);
        noticeService = new NoticeService(noticeRepository);
    }

    @Test
    public void 공지사항_개발_생성(){}

    @Test
    public void 공지사항_일괄_생성(){}

    @Test
    public void 공지사항_개별_조회(){}

    @Test
    public void 공지사항_페이지네이션_조회(){}

    @Test
    public void 공지사항_일괄_조회(){}

    @Test
    public void 공지사항_개별_수정(){}

    @Test
    public void 공지사항_개별_삭제(){}

}
