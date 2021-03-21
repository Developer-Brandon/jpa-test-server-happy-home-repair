package com.dkstudio.happyhomerepair.model.dto.response.item;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NoticeItem {

    @PositiveOrZero
    long beforeNoticeId;

    @PositiveOrZero
    long nextNoticeId;

    @PositiveOrZero
    long currentNoticeId;

    @NotBlank
    String noticeTitle;

    @NotBlank
    String noticeContents;

    @NotBlank
    String createdBy;

    @NotBlank
    @PastOrPresent
    String noticeRegisteredDate;
}
