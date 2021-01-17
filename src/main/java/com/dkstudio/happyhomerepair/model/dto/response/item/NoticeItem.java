package com.dkstudio.happyhomerepair.model.dto.response.item;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NoticeItem {
    @NotNull
    private Long beforeNoticeId;

    @NotNull
    private Long nextNoticeId;

    @NotNull
    private Long currentNoticeId;

    @NotNull
    private String noticeTitle;

    @NotNull
    private String noticeContents;

    @NotNull
    private String createdBy;

    @NotNull
    private String noticeRegisteredDate;
}
