package com.hypeboy.HoTalking.domain.auth.service;

import com.hypeboy.HoTalking.domain.auth.presentation.dto.Response.DAuthResponseDto;
import com.hypeboy.HoTalking.domain.auth.presentation.dto.Response.LoginResponseDto;
import com.hypeboy.HoTalking.domain.auth.presentation.dto.api.DOpenApiDto;
import com.hypeboy.HoTalking.domain.auth.presentation.dto.request.DAuthRequestDto;
import com.hypeboy.HoTalking.domain.auth.presentation.dto.request.LoginRequestDto;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.service.MemberService;
import com.hypeboy.HoTalking.global.config.properties.AppProperties;
import com.hypeboy.HoTalking.global.lib.jwt.JwtType;
import com.hypeboy.HoTalking.global.lib.jwt.JwtUtil;
import com.hypeboy.HoTalking.global.config.restTemplate.RestTemplateConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AppProperties appProperties;

    private final MemberService memberService;

    private final RestTemplateConfig restTemplateConfig;

    private final JwtUtil jwtUtil;

    private DOpenApiDto getCodeToDodamInfo(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "
                + getDAuthToken(code).getAccessToken());
        return restTemplateConfig.openTemplate().exchange(
                "/user",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                DOpenApiDto.class
        ).getBody();
    }


    private DAuthResponseDto getDAuthToken(String code) {
        return restTemplateConfig.authTemplate()
                .postForObject("/token", new HttpEntity<>(
                        DAuthRequestDto.builder()
                                .code(code)
                                .clientId(appProperties.getClient_id())
                                .clientSecret(appProperties.getClient_secret())
                                .build()
                ), DAuthResponseDto.class);
    }

    @Transactional
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        DOpenApiDto data = getCodeToDodamInfo(loginRequestDto.getCode());
        Member mem = memberService.save(data);
        String memberId = mem.getUniqueId();
        return LoginResponseDto.builder()
                .token(jwtUtil.generateToken(memberId, JwtType.ACCESS_TOKEN))
                .build();
    }

}