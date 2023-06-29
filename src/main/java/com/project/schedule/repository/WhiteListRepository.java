package com.project.schedule.repository;

import com.project.schedule.entity.WhiteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiteListRepository extends JpaRepository<WhiteList, Long> {

    WhiteList findByEmail(String email);
}
