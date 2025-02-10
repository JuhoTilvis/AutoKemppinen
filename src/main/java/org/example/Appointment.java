package org.example;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // Booking User

    private LocalDate date;
    private LocalTime time;

    private boolean available; // To check availability

    // Constructors
    public Appointment() {}

    public Appointment(Long id, LocalDate date, LocalTime time, boolean available) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.available = available;
    }
}