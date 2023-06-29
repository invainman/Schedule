package com.project.schedule.service.serviceImpl;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;
import com.project.schedule.repository.UserRepository;
import com.project.schedule.repository.WhiteListRepository;
import com.project.schedule.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final WhiteListRepository whiteListRepository;

    public UserServiceImpl(UserRepository userRepository, WhiteListRepository whiteListRepository) {
        this.userRepository = userRepository;
        this.whiteListRepository = whiteListRepository;
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
}
