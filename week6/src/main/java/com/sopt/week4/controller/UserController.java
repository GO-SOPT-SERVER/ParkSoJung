package com.sopt.week4.controller;

import com.sopt.week4.common.dto.ApiResponse;
import com.sopt.week4.config.jwt.JwtService;
import com.sopt.week4.controller.dto.UserLoginRequestDto;
import com.sopt.week4.controller.dto.UserLoginResponseDto;
import com.sopt.week4.controller.dto.UserRequestDto;
import com.sopt.week4.controller.dto.UserResponseDto;
import com.sopt.week4.exception.Success;
import com.sopt.week4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request);
        final String accessToken = jwtService.issuedAccessToken(String.valueOf(userId));
        final String refreshToken = jwtService.issuedRefreshToken(String.valueOf(userId));
        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, accessToken, refreshToken));
    }
}
