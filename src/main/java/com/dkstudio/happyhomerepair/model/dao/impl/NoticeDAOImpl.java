package com.dkstudio.happyhomerepair.model.dao.impl;

import com.dkstudio.happyhomerepair.model.dao.NoticeDAO;
import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;
import com.dkstudio.happyhomerepair.model.dto.response.NoticeResponseDTO;
import com.dkstudio.happyhomerepair.model.dto.response.item.NoticeItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository("NoticeDAOImpl")
public class NoticeDAOImpl implements NoticeDAO {

    @Inject
    SqlSession sqlSession;

    @Override
    public NoticeItem selectNotice(Long id) {
        return sqlSession.selectOne("selectNotice", id);
    }

    @Override
    public List<Object> selectNoticeList() {
        return sqlSession.selectList("selectNoticeList");
    }

    @Override
    public void insertNotice(Long noticeDTO) {
        sqlSession.insert("insertNotice", noticeDTO);
    }

    @Override
    public void updateNotice(NoticeDTO noticeDTO) {
        sqlSession.update("updateNotice", noticeDTO);
    }

    @Override
    public void deleteNotice(Long id) {
        sqlSession.delete("deleteNotice", id);
    }
}
