package com.dkstudio.happyhomerepair.model.dto.response;

import com.dkstudio.happyhomerepair.model.dto.response.item.NoticeItem;
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
public class NoticeResponseDTO {

    @NotNull
    NoticeItem noticeItem;
}
