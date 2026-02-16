package com.inovationtech.appointment_scheduling.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inovationtech.appointment_scheduling.infrastructure.entity.SchedulingEntity;

public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {
  
}
