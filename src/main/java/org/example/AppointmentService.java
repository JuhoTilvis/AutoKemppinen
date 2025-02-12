package org.example;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final List<Appointment> availableAppointments = new ArrayList<>();

    public AppointmentService() {
        availableAppointments.add(new Appointment(1L, LocalDate.of(2025, 2, 9), LocalTime.of(9, 0), true));
        availableAppointments.add(new Appointment(2L, LocalDate.of(2025, 2, 9), LocalTime.of(10, 0), true));
        availableAppointments.add(new Appointment(3L, LocalDate.of(2025, 2, 9), LocalTime.of(11, 0), false));
        availableAppointments.add(new Appointment(4L, LocalDate.of(2025, 2, 11), LocalTime.of(12, 0), false));
    }

    public boolean bookAppointment(AppointmentRequest request) {
        for (Appointment appointment : availableAppointments) {
            if (appointment.getDate().equals(request.getDate()) &&
                    appointment.getTime().equals(request.getTime()) &&
                    appointment.isAvailable()) {

                appointment.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public List<Appointment> getAvailableAppointments() {
        List<Appointment> available = new ArrayList<>();
        for (Appointment appointment : availableAppointments) {
            if (appointment.isAvailable()) {
                available.add(appointment);
            }
        }
        return available;
    }
}
