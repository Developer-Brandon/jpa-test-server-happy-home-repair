package com.dkstudio.happyhomerepair.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NoticeResponseDTO {
    private Long beforeNoticeId;
    private Long nextNoticeId;
    private Long currentNoticeId;
    private String noticeTitle;
    private String noticeContents;
    private LocalDateTime noticeRegisteredDate;
}
