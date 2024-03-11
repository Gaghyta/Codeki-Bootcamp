package com.example.TurneroMedico.controller;

import com.example.TurneroMedico.models.Appointment;
import com.example.TurneroMedico.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public Appointment findAppointmentById(@PathVariable Long id) {
        return appointmentService.findById(id);
    }




}
