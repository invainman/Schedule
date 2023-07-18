package com.project.schedule.service;

import com.project.schedule.dto.WhiteListDto;
import com.project.schedule.entity.WhiteList;

import java.util.List;

public interface WhiteListService {

    WhiteList addEmail(WhiteListDto whiteListDto);

    List<WhiteList> getAll();

    void deleteByEmail(String email);
}
