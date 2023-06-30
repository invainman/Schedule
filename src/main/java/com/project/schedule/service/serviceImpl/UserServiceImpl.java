package com.project.schedule.service.serviceImpl;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;
import com.project.schedule.repository.EventRepository;
import com.project.schedule.repository.UserRepository;
import com.project.schedule.repository.WhiteListRepository;
import com.project.schedule.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final WhiteListRepository whiteListRepository;

    private final EventRepository eventRepository;

    public UserServiceImpl(UserRepository userRepository, WhiteListRepository whiteListRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.whiteListRepository = whiteListRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public User create(UserDto userDto) {
        if (whiteListRepository.findByEmail(userDto.getEmail()) != null) {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteByEmail(String email) {
        User user = userRepository.findByEmail(email);
        eventRepository.deleteAllByUserId(user.getId());
        userRepository.deleteByEmail(email);
    }
}
