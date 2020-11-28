package com.dkstudio.happyhomerepair.controller;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import com.dkstudio.happyhomerepair.model.network.request.AdminUserApiRequest;
import com.dkstudio.happyhomerepair.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @PostMapping
    public ResponseEntity<?> createAdminUser(
            @RequestBody AdminUserApiRequest request
    ) throws URISyntaxException {

        AdminUser newAdminUser = adminUserService.createAdminUser(
                request.getEmail(),
                request.getPassword(),
                request.getName()
        );

        String url = "/api/admin" + newAdminUser.getId();
        return ResponseEntity
                .created(new URI(url))
                .body("{}");
    }

    @GetMapping("/{adminUserId}")
    public Optional<AdminUser> getIndividualAdminUserInfo(
            @PathVariable("adminUserId") Long adminUserId
    ) {
        return adminUserService.getAdminUser(adminUserId);
    }

    @GetMapping("/list")
    public List<AdminUser> getAdminUserList() {
        return adminUserService.getAdminUsers();
    }

    @PatchMapping("/{adminUserId}/update")
    public ResponseEntity<?> updateAdminUserAccount(
            @PathVariable Long adminUserId,
            @RequestBody AdminUserApiRequest adminUserApiRequest
    ) throws URISyntaxException {
        AdminUser updatedAdminUser = adminUserService.updateAccount(adminUserId, adminUserApiRequest.getName());
        String url = "/api/admin/" + updatedAdminUser.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @PatchMapping("/{adminUserId}/interactive")
    public ResponseEntity<?> interactiveAdminAccount(
            @PathVariable Long adminUserId
    ) throws URISyntaxException {
        // Delete User 를 대신 할 api 입니다.
        AdminUser updatedAdminUser = adminUserService.inactiveUser(adminUserId);
        String url = "/api/admin/" + updatedAdminUser.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
