package com.project.schedule.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EventDto {

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;
}
