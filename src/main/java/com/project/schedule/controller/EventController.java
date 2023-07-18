package com.project.schedule.controller;

import com.project.schedule.dto.EventDto;
import com.project.schedule.entity.Event;
import com.project.schedule.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Event>> getAllByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(eventService.getAllByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.create(eventDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
