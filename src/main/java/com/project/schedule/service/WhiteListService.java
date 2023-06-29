package com.project.schedule.service;

import com.project.schedule.dto.WhiteListDto;
import com.project.schedule.entity.WhiteList;

public interface WhiteListService {

    WhiteList addEmail(WhiteListDto whiteListDto);
}
