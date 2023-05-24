package com.Company.Dosinger.Model;

import com.Company.Dosinger.Enum.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "appointment")
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "appointment_id")
    String appointmentId;


    @Column(name = "appointment_date")
    @CreationTimestamp
    Date appointmentDate;


    @Column(name = "dose_number")
    @Enumerated(EnumType.STRING)
    DoseNumber doseNumber;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @ManyToOne
    @JoinColumn
    VaccinationCenter vaccinationCenter;
}
