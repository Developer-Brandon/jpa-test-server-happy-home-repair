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

    private AdminUserRepository adminUserRepository;

    private String ADMIN_NAME = "SUPER_ADMIN";

    @Autowired
    public AdminUserService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    public AdminUser createAdminUser(String email, String password, String name) {

        AdminUser adminUser = AdminUser.builder()
                .account(email)
                .password(password)
                .name(name)
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.NORMAL)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

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
                            .setUpdatedBy(ADMIN_NAME);
                    return adminUserEntity;
                })
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
                            .setUpdatedBy(ADMIN_NAME);
                    return adminUserEntity;
                })
                .orElseThrow(() -> new AdminUserNotFoundException(adminUserId));
    }

    public AdminUser inactiveUser(
            Long adminUserId
    ) {
        return adminUserRepository.findById(adminUserId)
                .map(adminUserEntity -> {
                    adminUserEntity
                            .setStatus(AdminUserState.INACTIVE)
                            .setUpdatedAt(LocalDateTime.now())
                            .setUpdatedBy(ADMIN_NAME);
                    return adminUserEntity;
                })
                .orElseThrow(() -> new AdminUserNotFoundException(adminUserId));
    }
}
