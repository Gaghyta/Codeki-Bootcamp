package com.example.TurneroMedico.services;

import com.example.TurneroMedico.models.Appointment;
import com.example.TurneroMedico.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }
    public ResponseEntity<String> updateById(Long id, Appointment updatedAppointment) {
        if (appointmentRepository.existsById(id)) {
            // Actualiza el turno con los datos que se le pasa
            updatedAppointment.setId(id);
            appointmentRepository.save(updatedAppointment);
            return ResponseEntity.ok("Appointment updated successfully");
        } else {
            // Devuelve la respuesta con el código de estado 404 y un mensaje para que se sepa que el id que se ha enviado no remite a ningun turno.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found with id: " + id);
        }
    }

    public List<Appointment> findAppointmentsByCostGreaterThan(int minCost) {
        List<Appointment> allAppointments = appointmentRepository.findAll();
        List<Appointment> highCostAppointments = new ArrayList<>();

        for (Appointment appointment : allAppointments) {
            if (appointment.getCost() != null && appointment.getCost() > minCost) {
                highCostAppointments.add(appointment);
            }
        }
        return highCostAppointments;
    }

    public List<Appointment> getByDoctorLastName(String doctorLastName) {
        List<Appointment> appointments = appointmentRepository.findByDoctorLastName(doctorLastName);
        return appointments;
    }
}
