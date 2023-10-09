package com.smarterschedule.server.availability;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarterschedule.server.user.User;
import com.smarterschedule.server.user.UserService;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private UserService userService;

    @GetMapping("/{uid}")
    public List<Availability> getAvailabilities(@PathVariable String uid) {
        return availabilityService.getAvailability(uid);
    }

    @PostMapping("/{uid}")
    public List<Availability> updateAvailability(@PathVariable String uid,
            @RequestBody List<Availability> availability) {
        User user = userService.getUserByUid(uid);
        for (Availability day : availability) {
            day.setUser(user);
        }
        return availabilityService.updateAvailability(availability);
    }

}
