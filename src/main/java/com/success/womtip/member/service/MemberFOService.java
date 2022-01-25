package com.success.womtip.member.service;

import com.success.womtip.entity.Member;
import com.success.womtip.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFOService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Member createMember(Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        return memberRepository.save(member);
    }

    public boolean idDupleCheck(String memberId){
        Member found =memberRepository.findMemberByMemberId(memberId);
        return found.getMemberCd() == null;
    }

}
