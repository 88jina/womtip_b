package com.success.womtip.utils.mail.repository;

import com.success.womtip.utils.mail.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByIdAndExpirationDateAfterAndExpired(Long confirmationTokenId, LocalDateTime now, boolean expired);

}
