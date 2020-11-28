package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.AdminUser;
import com.dkstudio.happyhomerepair.model.entity.AdminUserNotFoundException;
import com.dkstudio.happyhomerepair.model.enums.AdminUserRoleState;
import com.dkstudio.happyhomerepair.model.enums.AdminUserState;
import com.dkstudio.happyhomerepair.repository.AdminUserRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void 초기화() {
        MockitoAnnotations.initMocks(this);
        adminUserService = new AdminUserService(adminUserRepository);
    }

    @Test
    public void 어드민_유저_생성_테스트() {
        String email = "brandon@naver.com";
        String password = "asd1234!";
        String name = "BrandonLee";

        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account(email)
                .password(password)
                .name(name)
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRoleState.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserRepository.save(any())).willReturn(mockAdminUser);

        AdminUser adminUser = adminUserService.createAdminUser(email, password, name);

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
                .role(AdminUserRoleState.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserRepository.findById(any())).willReturn(Optional.of(mockAdminUser));

        Optional<AdminUser> adminUser = adminUserService.getAdminUser(0L);

        assertThat(adminUser.get().getId(), is(mockAdminUser.getId()));
    }

    @Test
    public void 어드민_모든_유저_읽기_존재할_경우_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRoleState.SUPER)
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
    public void 어드민_모든_유저_읽기_존재하지_않을_경우_테스트() {
        List<AdminUser> adminUserList = adminUserRepository.findAll();

        List<AdminUser> emptyAdminUserList = new ArrayList<>();

        assertThat(adminUserList, is(emptyAdminUserList)) ;
    }

    @Test
    public void 어드민_유저_정보_수정_성공_할_경우_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRoleState.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();


        given(adminUserRepository.findById(any()))
                .willReturn(Optional.ofNullable(mockAdminUser));

        adminUserService.updateInformation(
                0L,
                "BruceLee",
                AdminUserState.ACTIVE,
                AdminUserRoleState.SUPER
        );

        assertThat(mockAdminUser.getName(), is("BruceLee"));
        assertThat(mockAdminUser.getStatus(), is(AdminUserState.ACTIVE));
        assertThat(mockAdminUser.getRole(), is(AdminUserRoleState.SUPER));
    }

    @Test
    public void 어드민_유저_정보_수정_실패_할_경우_테스트() {
        long testId = 1L;

        expectedException.expect(AdminUserNotFoundException.class);

        adminUserService.updateInformation(
                testId,
                "BruceLee",
                AdminUserState.ACTIVE,
                AdminUserRoleState.SUPER
        );
    }

    public void 어드민_유저_이메일_수정_성공_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRoleState.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserRepository.findById(0L))
                .willReturn(Optional.ofNullable(mockAdminUser));

        adminUserService.updateAccount(
                0L,
                "singLung"
        );

        assertThat(mockAdminUser.getAccount(), is("singLung"));
    }

    @Test
    public void 어드민_유저_비활성화_성공_테스트() {
        AdminUser mockAdminUser = AdminUser.builder()
                .id(0L)
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRoleState.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        given(adminUserRepository.findById(any()))
                .willReturn(Optional.ofNullable(mockAdminUser));

        AdminUser inActivedUser = adminUserService.inactiveUser(0L);

        assertThat(inActivedUser.getStatus(), is(AdminUserState.INACTIVE));
    }
}
