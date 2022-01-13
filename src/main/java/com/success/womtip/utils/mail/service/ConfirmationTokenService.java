package com.success.womtip.utils.mail.service;

import com.success.womtip.utils.mail.entity.ConfirmationToken;
import com.success.womtip.utils.mail.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final MailSenderService mailSenderService;

    public Long createEmailConfirmationToken(String memberId, String receiverMail) {
        Assert.hasText(memberId, "memberId is required");
        Assert.hasText(receiverMail, "receiverMail is required");

        ConfirmationToken confirmationToken = ConfirmationToken.createEmailConfirmationToken(memberId);
        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(receiverMail);
        simpleMailMessage.setSubject("WOMTIP 이메일 인증");
        simpleMailMessage.setText("이메일 테스트");
        mailSenderService.sendMail(simpleMailMessage);

        return confirmationToken.getId();
    }


//    public ConfirmationToken findByIdAndExpirationDateAfterAndExpired(String confirmationTokenId) {
//        Optional<ConfirmationToken> confirmationToken = confirmationTokenRepository
//                .findByIdAndExpirationDateAfterAndExpired(confirmationTokenId, LocalDateTime.now(), false);
//        return confirmationToken.orElseThrow();
//    }


}
