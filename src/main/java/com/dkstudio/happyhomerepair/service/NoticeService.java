package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.Notice;
import com.dkstudio.happyhomerepair.model.entity.NoticeNotFoundException;
import com.dkstudio.happyhomerepair.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class NoticeService {
    private NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public void createNoticeList(List<Notice> noticeList) {
        //
    }

    public Notice getNoticeDetail(Long noticeId) {
        return new Notice();
    }

    public List<Notice> getAllNoticeList() {
        return new ArrayList<>();
    }

    public List<Notice> getNoticeListByOffset(Integer offset, Integer size) {
        return new ArrayList<>();
    }

    public Notice updateNotice(
            Long noticeId,
            String title,
            String content,
            LocalDateTime updatedDate
    ) {
        return noticeRepository.findById(noticeId)
                .map(noticeEntity -> {
                    noticeEntity
                            .setTitle(title)
                            .setContent(content)
                            .setUpdatedAt(updatedDate);
                    return noticeEntity;
                })
                .orElseThrow(() -> new NoticeNotFoundException(noticeId));
    }

    public void deleteNotice(
            Long noitceId
    ) {
        //
    }
}
