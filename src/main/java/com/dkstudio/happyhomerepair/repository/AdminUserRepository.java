package com.dkstudio.happyhomerepair.repository;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long>{
}
