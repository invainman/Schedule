package com.project.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

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
    }