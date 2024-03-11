package com.example.TurneroMedico.services;

import com.example.TurneroMedico.models.Appointment;
import com.example.TurneroMedico.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;


    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void createAppointment( Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public Optional<Appointment> findById(Long id) {
        return Optional.ofNullable(appointmentRepository.findById(id).orElse(null));
    }
}
