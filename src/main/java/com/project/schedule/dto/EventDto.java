package com.project.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EventDto {

    private String title;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm", timezone = "Europe/London")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm", timezone = "Europe/London")
    private Date endDate;

    private Long userId;
}
