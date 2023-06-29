package com.project.schedule.service.serviceImpl;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;
import com.project.schedule.repository.UserRepository;
import com.project.schedule.repository.WhiteListRepository;
import com.project.schedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WhiteListRepository whiteListRepository;

    @Override
    public User create(UserDto userDto) {
        if (whiteListRepository.findByEmail(userDto.getEmail())!= null) {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            return userRepository.save(user);
        }
        return null;
    }
}
