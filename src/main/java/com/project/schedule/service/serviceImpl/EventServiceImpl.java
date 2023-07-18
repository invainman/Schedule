package com.project.schedule.service.serviceImpl;

import com.project.schedule.dto.EventDto;
import com.project.schedule.entity.Event;
import com.project.schedule.repository.EventRepository;
import com.project.schedule.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllByUserId(Long userId) {
        return eventRepository.findAllByUserId(userId);
    }

    @Override
    public Event create(EventDto eventDto) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setUserId(eventDto.getUserId());
        return eventRepository.save(event);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}
