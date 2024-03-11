package com.example.TurneroMedico.controller;

import com.example.TurneroMedico.models.Appointment;
import com.example.TurneroMedico.repository.AppointmentRepository;
import com.example.TurneroMedico.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateAppointmentById(
            @PathVariable Long id,
            @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateById(id, updatedAppointment);
    }

    @GetMapping("/grather-than-cost-appointments/{minCost}")
    public List<Appointment> findAppointmentsByCostGreaterThan(@PathVariable int minCost) {
        return appointmentService.findAppointmentsByCostGreaterThan(minCost);
    }

    //EJEMPLO PREVIO HARDCODEADO

    /*@GetMapping("/cost-appointments")
    public List<Appointment> findAppointmentsByCostGreaterThan() {
        int minCost= 200;
        return appointmentService.findAppointmentsByCostGreaterThan(minCost);
    }*/








}
