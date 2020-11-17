package com.dkstudio.happyhomerepair.controller;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import com.dkstudio.happyhomerepair.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @PostMapping
    public ResponseEntity<?> createUser(
        @RequestBody AdminUser adminUser
    ) throws URISyntaxException {
        AdminUser newAdminUser= adminUserService.createAdminUser(adminUser);
        String url = "/api/admin" + newAdminUser.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @GetMapping("/{adminUserId}")
    public Optional<AdminUser> getUser(@PathVariable("adminUserId") Long adminUserId) {
        return adminUserService.getAdminUser(adminUserId);
    }

    @GetMapping("/list")
    public List<AdminUser> getUserList() {
        return adminUserService.getAdminUsers();
    }

    @PatchMapping("/{adminUserId}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long adminUserId,
            @RequestBody AdminUser adminUser
    ) throws URISyntaxException {
        // TODO: 어느 어느정보를 수정할 수 있도록 백단을 구성해야 하는가?
        String url = "/api/admin" + "새로 만들어진 어드민 객체에서 id를 빼서 삽입";
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
