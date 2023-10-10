package com.smarterschedule.server.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User getUserByUid(String uid) {
        Optional<User> user = userRepository.findByUid(uid);
        return user.orElseThrow(() -> new UserNotFoundException(uid));
    }

    public Long getUserIdByUid(String uid) {
        Optional<User> userOptional = userRepository.findByUid(uid);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(uid));
        return user.getId();
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User updateUser(User newUser, String uid) {
        return userRepository.findByUid(uid).map(user -> {
            user.setName(newUser.getName());
            user.setPhone(newUser.getPhone());
            return userRepository.save(user);
        }).orElseGet(() -> {
            return userRepository.save(newUser);
        });
    }

}
