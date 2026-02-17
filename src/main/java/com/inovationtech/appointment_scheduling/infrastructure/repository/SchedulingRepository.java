package com.inovationtech.appointment_scheduling.infrastructure.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inovationtech.appointment_scheduling.infrastructure.entity.SchedulingEntity;

import jakarta.transaction.Transactional;

public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {
  
  SchedulingEntity findByTreatmentAndAppointmentAtBetween(String treatment, LocalDateTime dateHourStart, LocalDateTime dateHourEnd);

  @Transactional
  void deleteByAppointmentAtToClient(LocalDateTime appointmentAt, String client);

  SchedulingEntity findByAppointmentAtBetween(LocalDateTime dateHourStart, LocalDateTime dateHourEnd);

  SchedulingEntity findByAppointmentAtToClient(LocalDateTime appointmentAt, String client);
}