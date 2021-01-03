package com.dkstudio.happyhomerepair.model.dao.impl;

import com.dkstudio.happyhomerepair.model.dao.NoticeDAO;
import com.dkstudio.happyhomerepair.model.dto.common.NoticeDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class NoticeDAOImpl implements NoticeDAO{

    @Inject
    SqlSession sqlSession;

    @Override
    public NoticeDTO selectNotice(Long id) {
        return sqlSession.selectOne("notice.selectNotice", id);
    }

    @Override
    public List<NoticeDTO> selectNoticeList() {
        return sqlSession.selectList("notice.selectNoticeList");
    }

    @Override
    public void insertNotice(Long noticeDTO) {
        sqlSession.insert("notice.insertNotice", noticeDTO);
    }

    @Override
    public void updateNotice(NoticeDTO noticeDTO) {
        sqlSession.update("notice.updateNotice", noticeDTO);
    }

    @Override
    public void deleteNotice(Long id) {
        sqlSession.delete("notice.deleteNotice", id);
    }
}
