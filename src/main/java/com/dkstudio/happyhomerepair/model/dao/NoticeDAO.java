package com.dkstudio.happyhomerepair.model.dao;

import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;

import java.util.List;

public interface NoticeDAO {
    NoticeDTO selectNotice(Long id);
    List<NoticeDTO> selectNoticeList();
    void insertNotice(Long noticeDTO);
    void updateNotice(NoticeDTO noticeDTO);
    void deleteNotice(Long id);
}
