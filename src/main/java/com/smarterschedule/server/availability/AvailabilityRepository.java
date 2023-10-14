package com.smarterschedule.server.availability;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByUserId(Long userId);
}
