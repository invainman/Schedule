package com.project.schedule.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class EventDto {

    private String title;

    private String description;

    private OffsetDateTime startDate;

    private OffsetDateTime endDate;

    private Long userId;
}
