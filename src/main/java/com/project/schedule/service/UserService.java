package com.project.schedule.service;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;

import java.util.List;

public interface UserService {

    User create(UserDto userDto);

    List<User> getAll();

    void deleteByEmail(String email);
}
