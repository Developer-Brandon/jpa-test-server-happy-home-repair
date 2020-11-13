package com.dkstudio.happyhomerepair.repository;

import com.dkstudio.happyhomerepair.model.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{
}
