package week3.advanced.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import week3.advanced.controller.dto.assembler.UserAssembler;
import week3.advanced.controller.dto.request.PostUserReq;
import week3.advanced.controller.dto.response.PostUserRes;
import week3.advanced.domain.User;
import week3.advanced.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;

    @Transactional
    public PostUserRes join(PostUserReq postUserReq) {
        User user = userRepository.save(userAssembler.toEntity(postUserReq));
        return PostUserRes.toEntity(user);
    }
}
