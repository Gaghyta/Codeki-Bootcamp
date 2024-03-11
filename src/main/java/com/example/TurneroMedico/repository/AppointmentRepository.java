package com.example.TurneroMedico.repository;

import com.example.TurneroMedico.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository <Appointment, Long> {
    List<Appointment> findByDoctorLastName(String doctorLastName);
}
