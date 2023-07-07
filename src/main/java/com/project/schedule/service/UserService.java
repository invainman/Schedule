package com.project.schedule.service;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;
import com.project.schedule.jwt.JwtLoginRequest;

import java.util.List;

public interface UserService {

    User create(UserDto userDto);

    List<User> getAll();

    void deleteByEmail(String email);

    User getByEmail(String email);

    String getTokenForLogin(JwtLoginRequest loginRequest);

    User getCurrent();
}
