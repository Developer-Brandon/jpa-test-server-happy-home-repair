package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.exception.BaseException;
import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeListResponseDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeResponseDTO;

public interface NoticeService {
    NoticeResponseDTO selectNotice(Long id) throws BaseException;
    NoticeListResponseDTO selectNoticeList() throws BaseException;
    void updateNotice(NoticeDTO noticeDTO) throws BaseException;
    void deleteNotice(Long id) throws BaseException;
}
