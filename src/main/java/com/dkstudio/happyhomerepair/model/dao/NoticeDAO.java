package com.dkstudio.happyhomerepair.model.dao;

import com.dkstudio.happyhomerepair.model.dto.response.item.NoticeItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class NoticeDAO {

    @Resource
    SqlSession sqlSession;

    public NoticeItem selectNotice(Long id) {
        return sqlSession.selectOne(  "selectNotice", id);
    }

    public List<NoticeItem> selectNoticeList() {
        return sqlSession.selectList("selectNoticeList");
    }
//
//    public void insertNotice(Long noticeDTO) {
//        sqlSessionTemplate.insert(MAPPER_NAME + "insertNotice", noticeDTO);
//    }
//
//    public void updateNotice(NoticeDTO noticeDTO) {
//        sqlSessionTemplate.update(MAPPER_NAME + "updateNotice", noticeDTO);
//    }
//
//    public void deleteNotice(Long id) {
//        sqlSessionTemplate.delete(MAPPER_NAME + "deleteNotice", id);
//    }
}
