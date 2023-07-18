package com.project.schedule.service;

import com.project.schedule.dto.EventDto;
import com.project.schedule.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> getAll();

    List<Event> getAllByUserId(Long userId);

    Event create(EventDto eventDto);

    void deleteById(Long id);
}
