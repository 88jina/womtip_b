package com.success.womtip.member.service;

import com.success.womtip.entity.Member;
import com.success.womtip.entity.Role;
import com.success.womtip.member.repository.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberFOService implements UserDetailsService {
    private final MemberRepository memberRepository;


    public MemberFOService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member signUp(Member member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        return  memberRepository.save(member);
    }


    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Optional<Member> memberWrapper = memberRepository.getMemberByMemberId(memberId);

        Member member = new Member();
        if(memberWrapper.isPresent()) member= memberWrapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin".equals(memberId)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }


        return new User(member.getMemberId(), member.getNickname(),authorities);
    }
}
