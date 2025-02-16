package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Boolean available;
}