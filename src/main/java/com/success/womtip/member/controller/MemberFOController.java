package com.success.womtip.member.controller;

import com.success.womtip.auth.service.AuthService;
import com.success.womtip.config.auth.PrincipalDetails;
import com.success.womtip.entity.Member;
import com.success.womtip.exception.UserLoginException;
import com.success.womtip.member.dto.LoginRequestDto;
import com.success.womtip.member.service.MemberFOService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fo/member")
@RequiredArgsConstructor
public class MemberFOController {

    private final MemberFOService memberFOService;
    private final MailSender mailSender;
    private final AuthService authService;

    @PostMapping("signup")
    public Member createMember(@RequestBody Member member) {
        return memberFOService.createMember(member);
    }

    @GetMapping("id/duple-check")
    public boolean idDupleCheck(@RequestParam String memberId) {
        return memberFOService.idDupleCheck(memberId);
    }

    @PostMapping("mail-auth")
    public String mailAuth(@RequestParam String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("sending mail test!");
        message.setTo(email);
        try {
            mailSender.send(message);
            return "sending done";
        }catch (Exception e){
            e.printStackTrace();
            return  "exception!";
        }
    }

    @PostMapping("signin")
    public Member authenticateMember(@RequestBody LoginRequestDto loginRequest){
        Authentication authentication = authService.authenticateUser(loginRequest)
                .orElseThrow(() -> new UserLoginException("Couldn't login user [" + loginRequest + "]"));
        return memberFOService.authenticateMember(authentication,loginRequest);
    }


}
