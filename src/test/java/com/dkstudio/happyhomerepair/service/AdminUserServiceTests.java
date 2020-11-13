package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import com.dkstudio.happyhomerepair.model.enums.AdminUserRole;
import com.dkstudio.happyhomerepair.model.enums.AdminUserState;
import com.dkstudio.happyhomerepair.repository.AdminUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class AdminUserServiceTests {

    private AdminUserService adminUserService;

    @Mock
    private AdminUserRepository adminUserRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        adminUserService = new AdminUserService(adminUserRepository);
    }

    @Test
    public void 어드민_유저_생성_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserRepository.save(any())).willReturn(mockAdminUser);

        AdminUser adminUser = adminUserService.createAdminUser(mockAdminUser);

        assertThat(adminUser.getAccount(), is(mockAdminUser.getAccount()));
    }
}
