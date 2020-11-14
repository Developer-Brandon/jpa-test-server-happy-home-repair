package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import com.dkstudio.happyhomerepair.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {
    AdminUserRepository adminUserRepository;

    @Autowired
    public AdminUserService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    public AdminUser createAdminUser(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    public Optional<AdminUser> getAdminUser(Long adminUserId) {
        return adminUserRepository.findById(adminUserId);
    }

    public List<AdminUser> getAdminUsers() {
        return adminUserRepository.findAll();
    }

    public AdminUser updateAdminUser(AdminUser user) {
        return adminUserRepository.findById(user.getId())
                .map(adminUserEntity -> {
                    adminUserEntity
                            .setAccount(user.getAccount())
                            .setPassword(user.getPassword())
                            .setName(user.getName())
                            .setStatus(user.getStatus())
                            .setRole(user.getRole())
                            .setPasswordUpdatedAt(LocalDateTime.now())
                            .setUpdatedAt(LocalDateTime.now())
                            .setUpdatedBy("DK-ADMIN");
                    return adminUserEntity;
                })
                .map(newAdminUser -> adminUserRepository.save(newAdminUser))
                .orElse(null);
    }
}
