package com.dkstudio.happyhomerepair.model.dto;

import com.dkstudio.happyhomerepair.model.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class NoticePagenation {
    private Integer totalPages;
    private Long totalElements;
    private Integer currentPage;
    private Integer currentElement;
    private List<Notice> noticeList;
}
