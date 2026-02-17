package com.inovationtech.appointment_scheduling.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.inovationtech.appointment_scheduling.infrastructure.entity.SchedulingEntity;
import com.inovationtech.appointment_scheduling.infrastructure.repository.SchedulingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchedulingService {
  
  private final SchedulingRepository schedulingRepository;

  public SchedulingEntity saveScheduling (SchedulingEntity scheduling) {
    LocalDateTime schedulingHour = scheduling.getAppointmentAt();
    LocalDateTime endHour = scheduling.getAppointmentAt().plusHours(1);

    SchedulingEntity schedulings = schedulingRepository.findByTreatmentAndAppointmentAtBetween(scheduling.getTreatment(), schedulingHour, endHour);

    if(Objects.nonNull(schedulings)) {
      throw new RuntimeException("Já existe um agendamento para este horário");
    }
    return schedulingRepository.save(scheduling);
  }

  public void deleteScheduling(LocalDateTime appointmentAt, String client) {
    schedulingRepository.deleteByAppointmentAtToClient(appointmentAt, client);
  }

  public SchedulingEntity findSchedulingByDay(LocalDate dateByDay) {
    LocalDateTime firstHourDay = dateByDay.atStartOfDay();
    LocalDateTime lastHourDay = dateByDay.atTime(23, 59, 59);

    return schedulingRepository.findByAppointmentAtBetween(firstHourDay, lastHourDay);
  }

  public SchedulingEntity updateScheduling(SchedulingEntity scheduling, String client, LocalDateTime appointmentAt) {
    SchedulingEntity updateScheduling = schedulingRepository.findByAppointmentAtToClient(appointmentAt, client);

    if(Objects.isNull(scheduling)) {
      throw new RuntimeException("Agendamento não encontrado para o cliente");
    }

    scheduling.setId(updateScheduling.getId());

    return schedulingRepository.save(scheduling);
  }
}
