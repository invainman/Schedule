package com.project.schedule.repository;

import com.project.schedule.entity.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Transactional
    void deleteAllByUserId(Long userId);

    List<Event> findAllByUserId(Long userId);
}
