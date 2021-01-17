package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeListResponseDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeResponseDTO;

public interface NoticeService {
    NoticeResponseDTO selectNotice(Long id);
    NoticeListResponseDTO selectNoticeList();
    void updateNotice(NoticeDTO noticeDTO);
    void deleteNotice(Long id);
}
