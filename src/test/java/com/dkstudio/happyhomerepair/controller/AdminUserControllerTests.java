package com.dkstudio.happyhomerepair.controller;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import com.dkstudio.happyhomerepair.model.enums.AdminUserRole;
import com.dkstudio.happyhomerepair.model.enums.AdminUserState;
import com.dkstudio.happyhomerepair.service.AdminUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminUserController.class)
public class AdminUserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminUserService adminUserService;

    @Test
    public void 어드민_유저_생성_성공() throws Exception {
        String account = "admin@example.com";
        String password = "asd123!";
        String name = "Administrator";

        AdminUser mockAdminUser = AdminUser.builder()
                .account(account)
                .password(password)
                .name(name)
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.NORMAL)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserService
                .createAdminUser(
                        account,
                        password,
                        name
                )
        ).willReturn(mockAdminUser);

        mockMvc.perform(
                post("/api/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                "{\"email\":\"admin@example.com\",\"password\":\"asd123!\",\"name\":\"Administrator\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));

        verify(adminUserService)
                .createAdminUser(
                        account,
                        password,
                        name
                );
    }

    @Test
    public void 어드민_유저_정보_조회_성공() throws Exception {
        Long adminUserId = 0L;
        String account = "admin@example.com";
        String password = "asd123!";
        String name = "Administrator";

        AdminUser mockAdminUser = AdminUser.builder()
                .id(adminUserId)
                .account(account)
                .password(password)
                .name(name)
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.NORMAL)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserService
                .getAdminUser(
                        adminUserId
                )).willReturn(Optional.ofNullable(mockAdminUser));

        mockMvc.perform(get("/api/admin/0"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":0")
                ))
                .andExpect(content().string(
                        containsString("\"account\":\"admin@example.com\"")
                ));
    }


    @Test
    public void 어드민_유저_이름_수정_성공() throws Exception {
        Long adminUserId = 0L;
        String account = "admin@example.com";
        String name = "Administrator";
        String password = "asd123!";

        AdminUser mockAdminUser = AdminUser.builder()
                .id(adminUserId)
                .account(account)
                .password(password)
                .name(name)
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.NORMAL)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserService.updateAccount(
                any(),
                any()
            )).willReturn(mockAdminUser);

        mockMvc.perform(patch("/api/admin/0/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                "{" +
                        "\"id\":0," +
                        "\"account\":\"admin@example.com\"," +
                        "\"name\":\"Administrator\"," +
                        "\"password\":\"asd123!\"" +
                        "}"
                ))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/api/admin/0"));
    }


    @Test
    public void 어드민_유저_비활성화_성공() throws Exception {
        Long adminUserId = 0L;
        String account = "admin@example.com";
        String name = "Administrator";
        String password = "asd123!";

        AdminUser mockAdminUser = AdminUser.builder()
                .id(adminUserId)
                .account(account)
                .password(password)
                .name(name)
                .status(AdminUserState.INACTIVE)
                .role(AdminUserRole.NORMAL)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserService.inactiveUser(adminUserId)).willReturn(mockAdminUser);

        mockMvc.perform(patch("/api/admin/0/interactive"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/api/admin/0"));

        verify(adminUserService).inactiveUser(0L);
    }
}
