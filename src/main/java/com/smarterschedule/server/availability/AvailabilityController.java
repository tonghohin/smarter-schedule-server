package com.smarterschedule.server.availability;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/{uid}")
    public List<Availability> getAvailabilities(@PathVariable String uid) {
        System.out.println(availabilityService.getAvailability(uid));
        return availabilityService.getAvailability(uid);
    }

    @PostMapping
    public List<Availability> updateAvailability(@RequestBody List<Availability> availability) {
        return availabilityService.updateAvailability(availability);
    }

}
