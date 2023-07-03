package com.project.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "event")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String description;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm", timezone = "Europe/London")
    Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm", timezone = "Europe/London")
    Date endDate;

    Long userId;

}
