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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void 초기화() {
        MockitoAnnotations.initMocks(this);
        adminUserService = new AdminUserService(adminUserRepository);
    }

    @Test
    public void 어드민_유저_생성_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
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

    @Test
    public void 어드민_특정_유저_읽기_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserRepository.findById(any())).willReturn(Optional.of(mockAdminUser));

        Optional<AdminUser> adminUser = adminUserService.getAdminUser(0L);

        assertThat(adminUser.get().getId(), is(mockAdminUser.getId()));
    }

    @Test
    public void 어드민_모든_유저_읽기_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        List<AdminUser> mockAdminUsers = new ArrayList<>();

        mockAdminUsers.add(mockAdminUser);

        given(adminUserRepository.findAll()).willReturn(mockAdminUsers);

        List<AdminUser> adminUsers = adminUserService.getAdminUsers();

        AdminUser adminUser = adminUsers.get(0);

        Long adminUserId = adminUser.getId();

        assertThat(adminUserId, is(0L));
    }

    @Test
    public void 어드민_유저_정보_수정_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();


        given(adminUserRepository
                .findById(0L))
                .willReturn(Optional.of(mockAdminUser));

        adminUserService.updateInformation(
                0L,
                "BruceLee",
                AdminUserState.ACTIVE,
                AdminUserRole.SUPER
        );

        assertThat(mockAdminUser.getName(), is("BruceLee"));
        assertThat(mockAdminUser.getStatus(), is(AdminUserState.ACTIVE));
        assertThat(mockAdminUser.getRole(), is(AdminUserRole.SUPER));
    }

    @Test
    public void 어드민_유저_이메일_수정_테스트() {

    }
}
