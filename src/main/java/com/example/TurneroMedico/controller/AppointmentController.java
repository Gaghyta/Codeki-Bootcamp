package com.example.TurneroMedico.controller;

import com.example.TurneroMedico.models.Appointment;
import com.example.TurneroMedico.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;



    @GetMapping("/all")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/add")
    public void createAppointment(@RequestBody Appointment appointment){
        appointmentService.createAppointment(appointment);
    }

    /*@GetMapping("/{id}")
    public Appointment findAppointmentById(@PathVariable Long id) {
        return appointmentService.findById(id);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.findById(id);
        return appointment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }




}
