package com.project.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "system_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String email;

        String password;

        String role;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "userId")
        private List<Event> events;
}