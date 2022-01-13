package com.success.womtip.utils.mail.entity;

import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class ConfirmationToken {


    private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private LocalDateTime expirationDate;
    @Column
    private boolean expired;
    @Column
    private String memberId;
    @Column
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public static ConfirmationToken createEmailConfirmationToken(String memberId){
        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.expirationDate = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE); // 5분후 만료
        confirmationToken.memberId = memberId;
        confirmationToken.expired = false;
        return confirmationToken;
    }
    public void useToken(){
        expired = true;
    }

}
