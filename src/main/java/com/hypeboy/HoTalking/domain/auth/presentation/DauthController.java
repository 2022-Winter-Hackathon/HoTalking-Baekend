package com.hypeboy.HoTalking.domain.auth.presentation;

import com.hypeboy.HoTalking.domain.auth.presentation.dto.Response.LoginResponseDto;
import com.hypeboy.HoTalking.domain.auth.presentation.dto.request.LoginRequestDto;
import com.hypeboy.HoTalking.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class DauthController {

    private final AuthService authService;

    @PostMapping("/login/dauth")
    public LoginResponseDto Login(@RequestBody LoginRequestDto loginRequestDto){
        return authService.login(loginRequestDto);
    }

}