package com.success.womtip.member.controller;

import com.success.womtip.entity.Member;
import com.success.womtip.member.service.MemberFOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fo/member")
@RequiredArgsConstructor
public class MemberFOController {

    private final MemberFOService memberFOService;

    @PostMapping("signup")
    public Member createMember(@RequestBody Member member) {
        return memberFOService.createMember(member);
    }

    @GetMapping("duple-check")
    public boolean dupleCheck(@RequestParam String memberId){
        return memberFOService.dupleCheck(memberId);
    }

}
