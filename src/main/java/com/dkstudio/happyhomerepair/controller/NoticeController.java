package com.dkstudio.happyhomerepair.controller;

import com.dkstudio.happyhomerepair.model.dto.response.NoticeResponseDTO;
import com.dkstudio.happyhomerepair.service.impl.NoticeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeServiceImpl noticeService;

    @RequestMapping(value =  "/{id}", method = RequestMethod.GET)
    public NoticeResponseDTO getNotice(@PathVariable Long id) {
        return noticeService.selectNotice(id);
    }
}
