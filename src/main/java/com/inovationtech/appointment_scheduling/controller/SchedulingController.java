package com.inovationtech.appointment_scheduling.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inovationtech.appointment_scheduling.infrastructure.entity.SchedulingEntity;
import com.inovationtech.appointment_scheduling.service.SchedulingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class SchedulingController {

  private final SchedulingService schedulingService;

  public ResponseEntity<SchedulingEntity> saveScheduling(@RequestBody SchedulingEntity scheduling) {
    return ResponseEntity.accepted().body(schedulingService.saveScheduling(scheduling));
  }

  public ResponseEntity<Void> deleteScheduling(@RequestParam LocalDateTime appointmentAt, @RequestParam String client) {
    schedulingService.deleteScheduling(appointmentAt, client);
    return ResponseEntity.accepted().build();
  }

  @GetMapping
  public ResponseEntity<SchedulingEntity> findSchedulingByDay(@RequestParam LocalDate day) {
    return ResponseEntity.ok().body(schedulingService.findSchedulingByDay(day));
  }

  @PutMapping
  public ResponseEntity<SchedulingEntity> updateScheduling(@RequestBody SchedulingEntity scheduling, @RequestParam String client, @RequestParam LocalDateTime appointmentAt) {
    return ResponseEntity.accepted().body(schedulingService.updateScheduling(scheduling, client, appointmentAt));
  }
}