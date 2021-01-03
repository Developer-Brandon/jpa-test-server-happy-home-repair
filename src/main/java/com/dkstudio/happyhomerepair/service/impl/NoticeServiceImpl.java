package com.dkstudio.happyhomerepair.service.impl;

import com.dkstudio.happyhomerepair.model.dao.impl.NoticeDAOImpl;
import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeListResponseDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeResponseDTO;
import com.dkstudio.happyhomerepair.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Inject
    NoticeDAOImpl noticeDAO;

    @Override
    public NoticeResponseDTO selectNotice(Long id) {
        NoticeDTO selectedNotice = noticeDAO.selectNotice(id);
        return NoticeResponseDTO.builder()
                .currentNoticeId(selectedNotice.getId())
                .noticeTitle(selectedNotice.getTitle())
                .noticeContents(selectedNotice.getContent())
                .noticeRegisteredDate(selectedNotice.getRegisteredAt())
                .build();
    }

    @Override
    public NoticeListResponseDTO selectNoticeList() {
        return null;
    }

    @Override
    public void updateNotice(NoticeDTO noticeDTO) {
        noticeDAO.updateNotice(noticeDTO);
    }

    @Override
    public void deleteNotice(Long id) {
        noticeDAO.deleteNotice(id);
    }
}
