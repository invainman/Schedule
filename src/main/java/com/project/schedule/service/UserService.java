package com.project.schedule.service;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;

public interface UserService {

    User create(UserDto userDto);
}
