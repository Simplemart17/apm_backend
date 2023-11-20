package com.apm.apm_backend.repository;

import com.apm.apm_backend.model.ConfirmationTokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenModel, Integer> {
    ConfirmationTokenModel findByConfirmationToken(String confirmationToken);
}
