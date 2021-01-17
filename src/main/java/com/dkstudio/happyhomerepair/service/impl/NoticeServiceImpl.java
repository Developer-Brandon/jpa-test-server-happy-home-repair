package com.dkstudio.happyhomerepair.service.impl;

import com.dkstudio.happyhomerepair.exception.CantFindDataException;
import com.dkstudio.happyhomerepair.model.dao.NoticeDAO;
import com.dkstudio.happyhomerepair.model.dto.response.item.NoticeItem;
import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeListResponseDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeResponseDTO;
import com.dkstudio.happyhomerepair.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    NoticeDAO noticeDAO;

    @Override
    public NoticeResponseDTO selectNotice(Long id) {
        NoticeResponseDTO noticeResponseDTO = NoticeResponseDTO.builder().build();
        try {
            NoticeItem noticeItem =
                    Optional
                        .ofNullable(noticeDAO.selectNotice(id))
                        .orElseThrow(CantFindDataException::new);
            noticeResponseDTO.setNoticeItem(noticeItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noticeResponseDTO;
    }

    @Override
    public NoticeListResponseDTO selectNoticeList() {
        return null;
    }

    @Override
    public void updateNotice(NoticeDTO noticeDTO) {
    }

    @Override
    public void deleteNotice(Long id) {
    }
}
