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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void 어드민_유저_생성() throws Exception {
        String email = "admin@example.com";
        String password = "asd123!";
        String name = "Administrator";

        AdminUser adminUser = AdminUser.builder()
                .account(email)
                .password("asd1234!")
                .name(name)
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.NORMAL)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserService
                .createAdminUser(
                    email,
                    password,
                    name
                )
        ).willReturn(adminUser);

        mockMvc.perform(
                post("/api/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                    "{\"email\":\"admin@example.com\",\"password\":\"asd123!\",\"name\":\"Administrator\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));

        verify(adminUserService)
                .createAdminUser(
                    email,
                    password,
                    name
                );
    }

//    @Test
//    public void 어드민_유저_조회() {
//    }
//
//    @Test
//    public void 어드민_유저_이름_수정() {
//    }
//
//    @Test
//    public void 어드민_유저_이름_삭제() {
//    }
//
//    @Test
//    public void 어드민_유저_비활성화() {
//    }
}
