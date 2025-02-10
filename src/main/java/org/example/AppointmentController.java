package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequest request) {
        boolean booked = appointmentService.bookAppointment(request);
        return booked ? ResponseEntity.ok("Appointment Booked!") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Slot Unavailable");
    }

    @GetMapping("/available")
    public List<Appointment> getAvailableSlots() {
        return appointmentService.getAvailableAppointments();
    }
}