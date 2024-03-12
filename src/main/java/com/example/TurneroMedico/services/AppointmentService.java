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
        return appointmentRepository.findById(id);
    }

    /*public Appointment findById2(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }*/

    public void deleteById(Long id) {

        appointmentRepository.deleteById(id);
    }


    //OPCION DE CLASE  SIN ID- SIN ENTITY SIN MAP - CON FIND ID ORELSE NULL
    // OPCIÓN DE UPDATE DE CLASE - SE CONSULTA DOS VECES A LA BD
    public Appointment update (Appointment appointment) {
        // GUARDA EL TURNO
        appointmentRepository.save(appointment);
        //DEVUELVE EL TURNO O NULO
        return appointmentRepository.findById(appointment.getId()).orElse(null);
    }


    // OPCION DIRECTA NO VALIDA NULOS
    /* public Appointment update(Appointment appointment) {
       return appointmentRepository.save(appointment);
    }*/

    //OPCION ELEGIDA CON RESPONSE ENTITY UNICA CONSULTA A LA BASE DE DATOS
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

   /* public ResponseEntity<String> updateById(Long id, Appointment updatedAppointment) {
        Optional<Appointment> existingAppointmentOptional = appointmentRepository.findById(id);

        if (existingAppointmentOptional.isPresent()) {
            // Actualiza el turno con los datos que se le pasa
            Appointment existingAppointment = existingAppointmentOptional.get();
            existingAppointment.setId(id);
            // propiedades
            existingAppointment.setDoctorName(updatedAppointment.getDoctorName());
            existingAppointment.setDoctorLastName(updatedAppointment.getDoctorLastName());
            existingAppointment.setMedicalPacientName(updatedAppointment.getMedicalPacientName());
            existingAppointment.setMedicalPacientLastName(updatedAppointment.getMedicalPacientLastName());
            existingAppointment.setSpecialty(updatedAppointment.getSpecialty());
            existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
            existingAppointment.setTypeOfConsulting(updatedAppointment.getTypeOfConsulting());
            existingAppointment.setMedicalCoverage(updatedAppointment.getMedicalCoverage());
            existingAppointment.setCopayment(updatedAppointment.getCopayment());
            existingAppointment.setCost(updatedAppointment.getCost());
            appointmentRepository.save(existingAppointment);
            return ResponseEntity.ok("Appointment updated successfully");
        } else {
            // Devuelve la respuesta con el código de estado 404 y un mensaje para que se sepa que el id que se ha enviado no remite a ningun turno.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found with id: " + id);
        }
    }*/

    // OPCION CON MAP - TAMBIEN SE CONSULTA DOS VECES A LA BD - util si se requiera actualizar solo algunos campos
   /* public Appointment update(Appointment appointment) {
        return appointmentRepository.findById(appointment.getId())
                .map(existingAppointment -> {
                    existingAppointment.setDoctorName(appointment.getDoctorName());
                    existingAppointment.setDoctorLastName(appointment.getDoctorLastName());
                    existingAppointment.setMedicalPacientName(appointment.getMedicalPacientName());
                    existingAppointment.setMedicalPacientLastName(appointment.getMedicalPacientLastName());
                    existingAppointment.setSpecialty(appointment.getSpecialty());
                    existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
                    existingAppointment.setTypeOfConsulting(appointment.getTypeOfConsulting());
                    existingAppointment.setMedicalCoverage(appointment.getMedicalCoverage());
                    existingAppointment.setCopayment(appointment.getCopayment());
                    existingAppointment.setCost(appointment.getCost());

                    return appointmentRepository.save(existingAppointment);
                })
                .orElse(null);
    }*/

    // OPCION USO DE "FIND ID" Y "SAVE" SIN RESPONSE ENTITY, Y SIN MAP
   /* public Appointment update(Appointment appointment) {
        if (appointment.getId() != null && appointmentRepository.existsById(appointment.getId())) {
            return appointmentRepository.save(appointment);
        }
        return null; // O manejo de error según tus necesidades
    }*/



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
        //List<Appointment> appointments = appointmentRepository.findByDoctorLastName(doctorLastName);
        //return appointments;
        return appointmentRepository.findByDoctorLastName(doctorLastName);
    }
}
