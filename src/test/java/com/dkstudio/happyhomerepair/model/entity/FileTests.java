package com.dkstudio.happyhomerepair.model.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class FileTests {
    @Test
    public void 파일_정보_생성_테스트() {
        File file = File.builder()
                .name("증명사진_20101010")
                .build();
        assertNotNull(file);
        assertThat(file.getName(), is("증명사진_20101010"));
    }
}
