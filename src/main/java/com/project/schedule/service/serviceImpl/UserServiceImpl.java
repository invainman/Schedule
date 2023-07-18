package com.project.schedule.service.serviceImpl;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;
import com.project.schedule.jwt.JwtAnswer;
import com.project.schedule.jwt.JwtLoginRequest;
import com.project.schedule.jwt.JwtService;
import com.project.schedule.repository.EventRepository;
import com.project.schedule.repository.UserRepository;
import com.project.schedule.repository.WhiteListRepository;
import com.project.schedule.service.UserService;
import com.project.schedule.util.AuthUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final WhiteListRepository whiteListRepository;

    private final EventRepository eventRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, WhiteListRepository whiteListRepository,
                           EventRepository eventRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.whiteListRepository = whiteListRepository;
        this.eventRepository = eventRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public User create(UserDto userDto) {
        if (whiteListRepository.findByEmail(userDto.getEmail()).isPresent()) {
            userRepository.findByEmail(userDto.getEmail()).ifPresent(theUser ->
            {
                throw new RuntimeException(String.format("User with email %s already exists", userDto.getEmail()));
            });
            User user = new User();
            user.setRole("USER");
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
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
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(String.format("User with email %s not found", email)));
        eventRepository.deleteAllByUserId(user.getId());
        userRepository.deleteByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with email %s not found", email)));
    }

    @Override
    public JwtAnswer getTokenForLogin(JwtLoginRequest loginRequest) {
        User user = getByEmail(loginRequest.getEmail());
        JwtAnswer jwtAnswer = new JwtAnswer();
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            jwtAnswer.setToken(jwtService.generateToken(loginRequest.getEmail()));
            return jwtAnswer;
        }
        throw new RuntimeException("Password entered incorrectly");
    }

    @Override
    public User getCurrent() {
        Long id = Objects.requireNonNull(AuthUtils.getAccountDetails()).getUserId();
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with id %s not found", id)));
    }
}
