package com.apm.apm_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apm.apm_backend.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
