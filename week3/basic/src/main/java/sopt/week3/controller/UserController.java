package sopt.week3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sopt.week3.controller.dto.ApiResponseDto;
import sopt.week3.controller.dto.request.UserRequestDto;
import sopt.week3.controller.dto.response.UserResponseDto;
import sopt.week3.exception.SuccessStatus;
import sopt.week3.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<ApiResponseDto<UserResponseDto>> create(@RequestBody @Valid final UserRequestDto request) {
        return new ResponseEntity<>(ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request)), HttpStatus.CREATED);
    }
}
