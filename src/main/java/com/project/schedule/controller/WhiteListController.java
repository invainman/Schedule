package com.project.schedule.controller;

import com.project.schedule.dto.WhiteListDto;
import com.project.schedule.entity.WhiteList;
import com.project.schedule.service.WhiteListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whitelist")
public class WhiteListController {

    private final WhiteListService whiteListService;

    public WhiteListController(WhiteListService whiteListService) {
        this.whiteListService = whiteListService;
    }

    @PostMapping
    public ResponseEntity<WhiteList> addEmailToWhiteList(@RequestBody WhiteListDto whiteListDto) {
        return new ResponseEntity<>(whiteListService.addEmail(whiteListDto), HttpStatus.CREATED);
    }
}
