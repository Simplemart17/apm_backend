package com.apm.apm_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apm.apm_backend.model.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUserEmailIgnoreCase(String emailId);

    Boolean existsByUserEmail(String userEmail);
}
