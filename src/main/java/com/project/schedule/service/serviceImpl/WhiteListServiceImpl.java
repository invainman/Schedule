package com.project.schedule.service.serviceImpl;

import com.project.schedule.dto.WhiteListDto;
import com.project.schedule.entity.User;
import com.project.schedule.entity.WhiteList;
import com.project.schedule.repository.EventRepository;
import com.project.schedule.repository.UserRepository;
import com.project.schedule.repository.WhiteListRepository;
import com.project.schedule.service.WhiteListService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhiteListServiceImpl implements WhiteListService {

    private final UserRepository userRepository;

    private final WhiteListRepository whiteListRepository;

    private final EventRepository eventRepository;

    public WhiteListServiceImpl(UserRepository userRepository, WhiteListRepository whiteListRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.whiteListRepository = whiteListRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public WhiteList addEmail(WhiteListDto whiteListDto) {
        WhiteList whiteList = new WhiteList(whiteListDto.getEmail());
        return whiteListRepository.save(whiteList);
    }

    @Override
    public List<WhiteList> getAll() {
        return whiteListRepository.findAll();
    }

    @Override
    public void deleteByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(String.format("User with email %s not found", email)));
        eventRepository.deleteAllByUserId(user.getId());
        userRepository.deleteByEmail(email);
        whiteListRepository.deleteByEmail(email);
    }
}
