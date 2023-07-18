package com.project.schedule.repository;

import com.project.schedule.entity.WhiteList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WhiteListRepository extends JpaRepository<WhiteList, Long> {

    Optional<WhiteList> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
