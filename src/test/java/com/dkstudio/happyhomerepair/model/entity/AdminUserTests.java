package com.dkstudio.happyhomerepair.model.entity;

import com.dkstudio.happyhomerepair.model.enums.AdminUserRole;
import com.dkstudio.happyhomerepair.model.enums.AdminUserState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class AdminUserTests {
    @Test
    public void 어드민_유저_생성_테스트() {
        AdminUser adminUser = AdminUser.builder()
                .account("brandon@naver.com")
                .password("asd1234!")
                .name("BrandonLee")
                .status(AdminUserState.ACTIVE)
                .role(AdminUserRole.SUPER)
                .lastLoginAt(LocalDateTime.now())
                .loginFailCount(0)
                .registeredAt(LocalDateTime.now())
                .build();

        assertNotNull(adminUser);
        assertThat(adminUser.getAccount(), is("brandon@naver.com"));
    }
}
