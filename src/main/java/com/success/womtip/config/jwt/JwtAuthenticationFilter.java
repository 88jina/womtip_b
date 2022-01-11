package com.success.womtip.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.success.womtip.config.auth.PrincipalDetails;
import com.success.womtip.member.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        log.debug("JWT AUTHENTICATION FILTER STARTED");

        ObjectMapper om = new ObjectMapper();
        LoginRequestDto loginRequestDto = null;
        try {
            loginRequestDto = om.readValue(request.getInputStream(), LoginRequestDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.debug("JWT AUTHENTICATION FILTER >>>>>>>>>>>>>> " + loginRequestDto);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getMemberId(),
                        loginRequestDto.getPassword());

        log.debug("JWT AUTHENTICATION FILTER >>>>>>>>>>>> 토큰생성완료");

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();


        log.debug("AUTHENTICATION : "+principalDetails.getUsername());

        return authentication;
    }
}


