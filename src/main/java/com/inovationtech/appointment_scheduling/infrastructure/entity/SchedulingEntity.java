package com.inovationtech.appointment_scheduling.infrastructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "scheduling")
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private Long id;
  private String treatment;
  private String professional;
  private String client;
  private LocalDateTime appointmentAt;
  private LocalDateTime createAt = LocalDateTime.now();

}
