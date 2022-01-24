package com.success.womtip.member.service;

import com.success.womtip.config.auth.PrincipalDetails;
import com.success.womtip.entity.Member;
import com.success.womtip.member.dto.LoginRequestDto;
import com.success.womtip.member.repository.MemberRepository;
import com.success.womtip.token.entity.RefreshToken;
import com.success.womtip.token.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFOService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RefreshTokenService refreshTokenService;

    public Member createMember(Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        return memberRepository.save(member);
    }

    public boolean idDupleCheck(String memberId) {
        Member found = memberRepository.findMemberByMemberId(memberId);
        return found.getMemberCd() == null;
    }

    public boolean nickDupleCheck(String nickname) {
        Member found = memberRepository.findMemberByNickname(nickname);
        return found.getMemberCd() == null;
    }

    public Member authenticateMember(Authentication authentication, LoginRequestDto loginRequest) {

        Member currentMember = (Member)authentication.getPrincipal();
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        RefreshToken refreshToken = refreshTokenService.createRefreshToken();

        return null;
    }
}
