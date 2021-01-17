package com.dkstudio.happyhomerepair.controller;

import com.dkstudio.happyhomerepair.model.dto.response.NoticeResponseDTO;
import com.dkstudio.happyhomerepair.service.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeServiceImpl noticeService;

    @RequestMapping(value =  "/{id}", method = RequestMethod.GET)
    public NoticeResponseDTO getNotice(@PathVariable Long id) {
        return noticeService.selectNotice(id);
    }
}
