package com.project.schedule.service.serviceImpl;

import com.project.schedule.dto.WhiteListDto;
import com.project.schedule.entity.WhiteList;
import com.project.schedule.repository.WhiteListRepository;
import com.project.schedule.service.WhiteListService;
import org.springframework.stereotype.Service;

@Service
public class WhiteListServiceImpl implements WhiteListService {

    private final WhiteListRepository whiteListRepository;

    public WhiteListServiceImpl(WhiteListRepository whiteListRepository) {
        this.whiteListRepository = whiteListRepository;
    }

    @Override
    public WhiteList addEmail(WhiteListDto whiteListDto) {
        WhiteList whiteList = new WhiteList(whiteListDto.getEmail());
        return whiteListRepository.save(whiteList);
    }
}
