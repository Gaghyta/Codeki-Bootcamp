package com.example.TurneroMedico.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;


@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String doctorName;
    private String doctorLastname;
    private String medicalPacientName;
    private String medicalPacientLastName;
    private String specialty;
    private String appointmentDate;
    private String typeOfConsulting;
    private String medicalCoverage;
    private Boolean copayment;

    public Appointment(String doctorName, String doctorLastname, String medicalPacientName, String medicalPacientLastName, String specialty, String appointmentDate, String typeOfConsulting, String medicalCoverage, Boolean copayment) {
        this.doctorName = doctorName;
        this.doctorLastname = doctorLastname;
        this.medicalPacientName = medicalPacientName;
        this.medicalPacientLastName = medicalPacientLastName;
        this.specialty = specialty;
        this.appointmentDate = appointmentDate;
        this.typeOfConsulting = typeOfConsulting;
        this.medicalCoverage = medicalCoverage;
        this.copayment = copayment;
    }
}
