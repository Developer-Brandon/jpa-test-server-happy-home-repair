package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.Notice;
import com.dkstudio.happyhomerepair.repository.NoticeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    public void 공지사항_개별_생성_테스트(){
        Notice mockNotice = Notice.builder()
                .id(0L)
                .title("첫번째 공지사항 제목입니다")
                .content("첫번째 공지사항 내용입니다")
                .build();

        // given
        given(noticeRepository.save(any())).willReturn(mockNotice);

        // when
        Notice savedNotice = noticeService.createNotice(mockNotice);

        //then
        assertThat(savedNotice.getTitle(), is(mockNotice.getTitle()));
        assertThat(savedNotice.getContent(), is(mockNotice.getContent()));
    }

    @Test
    public void 공지사항_일괄_생성_테스트(){
        // given
        Notice mockNotice1 = Notice.builder()
                .id(0L)
                .title("첫번째 공지사항 제목입니다")
                .content("첫번째 공지사항 내용입니다")
                .build();

        Notice mockNotice2 = Notice.builder()
                .id(1L)
                .title("두번째 공지사항 제목입니다")
                .content("두번째 공지사항 내용입니다")
                .build();

        List<Notice> noticeList = new ArrayList<>();
        noticeList.add(mockNotice1);
        noticeList.add(mockNotice2);

        // when
        noticeService.createNoticeList(noticeList);

        // then
        verify(noticeRepository, times(2)).save(any());
    }

    @Test
    public void 공지사항_개별_조회_테스트(){
        // given
        Notice mockNotice = Notice.builder()
                .id(0L)
                .title("첫번째 공지사항 제목입니다")
                .content("첫번째 공지사항 내용입니다")
                .build();

        given(noticeRepository.findById(mockNotice.getId())).willReturn(java.util.Optional.ofNullable(mockNotice));

        // when
        Notice updatedNotice = noticeService.getNoticeDetail(mockNotice.getId());

        // then
        assertThat(mockNotice.getTitle(), is(updatedNotice.getTitle()));
        assertThat(mockNotice.getContent(), is(updatedNotice.getContent()));
    }

    @Test
    public void 공지사항_일괄_조회_테스트(){
        // given
        Notice mockNotice1 = Notice.builder()
                .id(0L)
                .title("첫번째 공지사항 제목입니다")
                .content("첫번째 공지사항 내용입니다")
                .build();

        Notice mockNotice2 = Notice.builder()
                .id(1L)
                .title("두번째 공지사항 제목입니다")
                .content("두번째 공지사항 내용입니다")
                .build();

        List<Notice> mockNoticeList = new ArrayList<>();
        mockNoticeList.add(mockNotice1);
        mockNoticeList.add(mockNotice2);

        given(noticeRepository.findAll()).willReturn(mockNoticeList);

        // when
        List<Notice>updatedNoticeList = noticeService.getAllNoticeList();

        // then
        assertThat(updatedNoticeList.get(0).getTitle(), contains("제목"));
        assertThat(updatedNoticeList.get(0).getContent(), contains("내용"));
    }

    @Test
    public void 공지사항_페이지네이션_조회_테스트(){
        // given
        Integer offset = 0;
        Integer size = 10;
        Pageable pageable = PageRequest.of(offset, size);

        Notice mockNotice1 = Notice.builder()
                .id(0L)
                .title("첫번째 공지사항 제목입니다")
                .content("첫번째 공지사항 내용입니다")
                .build();

        Notice mockNotice2 = Notice.builder()
                .id(1L)
                .title("두번째 공지사항 제목입니다")
                .content("두번째 공지사항 내용입니다")
                .build();

        List<Notice> mockNoticeList = new ArrayList<>();
        mockNoticeList.add(mockNotice1);
        mockNoticeList.add(mockNotice2);

        Page<Notice> mockNoticePage = (Page<Notice>) mockNoticeList;

        given(noticeRepository.findAll(pageable))
                .willReturn(mockNoticePage);

        // when
        noticeService.getNoticeListByOffset(offset, size);

        // then
        assertThat(mockNoticePage.get().count(), is(2));
        assertThat(mockNoticePage.getTotalElements(), is(2));
        assertThat(mockNoticePage.getTotalPages(), is(1));
    }

    @Test
    public void 공지사항_개별_수정_테스트(){
        // given
        Long mockNoticeId = 0L;
        String mockNoticeTitle = "첫번째 공지사항 제목입니다";
        String mockNoticeContent = "첫번째 공지사항 내용입니다";

        Notice mockNotice = Notice.builder()
                .title(mockNoticeTitle)
                .content(mockNoticeContent)
                .build();

        given(noticeRepository.findById(mockNoticeId))
                .willReturn(java.util.Optional.ofNullable(mockNotice));

        // when
        Notice updatedNotice = noticeService.updateNotice(mockNoticeId, mockNoticeTitle, mockNoticeContent);

        // then
        assertThat(updatedNotice.getTitle(), containsString("제목"));
        assertThat(updatedNotice.getContent(), containsString("내용"));
    }

    @Test
    public void 공지사항_개별_삭제_테스트(){
        // given
        Long mockNoticeId = 0L;

        // when
        noticeService.deleteNotice(mockNoticeId);

        // then
        verify(noticeRepository, times(1)).deleteById(mockNoticeId);
    }
}
