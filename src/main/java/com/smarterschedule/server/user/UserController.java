package com.smarterschedule.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarterschedule.server.availability.AvailabilityService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        User createdUser = userService.createOrUpdateUser(newUser);
        availabilityService.createDefaultAvailability(createdUser);
        return createdUser;
    }

    @GetMapping("/{uid}")
    public User getUserByUid(@PathVariable String uid) {
        return userService.getUserByUid(uid);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.createOrUpdateUser(user);
    }

}
