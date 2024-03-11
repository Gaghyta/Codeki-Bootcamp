package com.example.TurneroMedico.repository;

import com.example.TurneroMedico.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository <Appointment, Long> {
}
