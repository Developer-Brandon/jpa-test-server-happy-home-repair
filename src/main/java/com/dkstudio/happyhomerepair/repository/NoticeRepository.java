package com.dkstudio.happyhomerepair.repository;

import com.dkstudio.happyhomerepair.model.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>{
}
