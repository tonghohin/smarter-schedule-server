package com.smarterschedule.server.user;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(String uid) {
        super("Could not find user with uid " + uid);
    }

    UserNotFoundException(Long userId) {
        super("Could not find user with User Id " + userId);
    }

}
