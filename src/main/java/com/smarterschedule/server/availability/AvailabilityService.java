package com.smarterschedule.server.availability;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarterschedule.server.student.Student;
import com.smarterschedule.server.user.User;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<Availability> createDefaultAvailability(User user) {
        List<Availability> defaultAvailability = new ArrayList<>();
        for (int dayOfWeek = 0; dayOfWeek <= 6; dayOfWeek++) {
            Availability availability = new Availability(dayOfWeek, null, null, false);
            availability.setUser(user);
            defaultAvailability.add(availability);
        }
        return availabilityRepository.saveAll(defaultAvailability);
    }

    public List<Availability> createAvailability(Student student, List<Availability> availability) {
        for (Availability eachAvailability : availability) {
            eachAvailability.setStudent(student);
        }
        return availabilityRepository.saveAll(availability);
    }

}
