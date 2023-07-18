package com.project.schedule.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "white_list")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WhiteList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;

    public WhiteList(String email) {
        this.email = email;
    }
}
