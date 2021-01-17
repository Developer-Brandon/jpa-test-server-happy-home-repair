package com.dkstudio.happyhomerepair.model.dao;

import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;
import com.dkstudio.happyhomerepair.model.dto.response.item.NoticeItem;

import java.util.List;

public interface NoticeDAO {
    NoticeItem selectNotice(Long id);
    List<Object> selectNoticeList();
    void insertNotice(Long noticeDTO);
    void updateNotice(NoticeDTO noticeDTO);
    void deleteNotice(Long id);
}
