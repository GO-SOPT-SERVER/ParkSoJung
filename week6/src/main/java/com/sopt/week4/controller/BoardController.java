package com.sopt.week4.controller;

import com.sopt.week4.common.dto.ApiResponse;
import com.sopt.week4.config.jwt.JwtService;
import com.sopt.week4.config.resolver.UserId;
import com.sopt.week4.controller.dto.BoardRequestDto;
import com.sopt.week4.exception.Success;
import com.sopt.week4.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(userId, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
