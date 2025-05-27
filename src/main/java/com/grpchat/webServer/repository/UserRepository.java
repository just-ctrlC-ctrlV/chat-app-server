package com.grpchat.webServer.repository;

import com.grpchat.webServer.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByEmail(String email);
}
