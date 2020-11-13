package com.dkstudio.happyhomerepair.model.entity;

import com.dkstudio.happyhomerepair.model.enums.EstimateLocalState;
import com.dkstudio.happyhomerepair.model.enums.EstimateState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class EstimateTests {
    @Test
    public void 내장수리_신청서_테스트() {
        Estimate estimate = Estimate.builder()
                .agreement(true)
                .locate(EstimateLocalState.SEOUL)
                .type(EstimateState.DOOR)
                .detail("문이 열리지 않습니다.")
                .phoneNumber("01084302253")
                .build();
        assertNotNull(estimate);
        assertThat(estimate.getPhoneNumber(), is("01084302253"));
    }
}
