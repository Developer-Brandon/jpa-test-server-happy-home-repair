package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import com.dkstudio.happyhomerepair.model.entity.AdminUserNotFoundException;
import com.dkstudio.happyhomerepair.model.enums.AdminUserRole;
import com.dkstudio.happyhomerepair.model.enums.AdminUserState;
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

    public AdminUser updateInformation(
            Long adminUserId,
            String userName,
            AdminUserState adminUserState,
            AdminUserRole adminUserRole
    ) {
        return adminUserRepository.findById(adminUserId)
                .map(adminUserEntity -> {
                    adminUserEntity
                            .setName(userName)
                            .setStatus(adminUserState)
                            .setRole(adminUserRole)
                            .setUpdatedAt(LocalDateTime.now())
                            .setUpdatedBy("SuperAdmin");
                    return adminUserEntity;
                })
                .map(newAdminUser -> adminUserRepository.save(newAdminUser))
                .orElseThrow(() -> new AdminUserNotFoundException(adminUserId));
    }

    public AdminUser updateAccount(
            Long adminUserId,
            String adminUserAccount
    ) {
        return adminUserRepository.findById(adminUserId)
                .map(adminUserEntity -> {
                    adminUserEntity
                            .setAccount(adminUserAccount)
                            .setUpdatedAt(LocalDateTime.now())
                            .setUpdatedBy("SuperAdmin");
                    return adminUserEntity;
                })
                .map(newAdminUser -> adminUserRepository.save(newAdminUser))
                .orElseThrow(() -> new AdminUserNotFoundException(adminUserId));
    }
}
