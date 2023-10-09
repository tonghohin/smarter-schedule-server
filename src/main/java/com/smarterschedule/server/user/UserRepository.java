package com.smarterschedule.server.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUid(String uid);
}
