package com.sopt.week4.service;

import com.sopt.week4.controller.dto.BoardRequestDto;
import com.sopt.week4.domain.Board;
import com.sopt.week4.domain.User;
import com.sopt.week4.exception.Error;
import com.sopt.week4.exception.model.NotFoundException;
import com.sopt.week4.infrastructure.BoardRepository;
import com.sopt.week4.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void create(Long userId, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }
}
