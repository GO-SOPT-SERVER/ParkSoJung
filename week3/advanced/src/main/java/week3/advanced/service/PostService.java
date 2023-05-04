package week3.advanced.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week3.advanced.controller.dto.assembler.PostAssembler;
import week3.advanced.controller.dto.request.PostReq;
import week3.advanced.controller.dto.response.PostRes;
import week3.advanced.domain.Post;
import week3.advanced.domain.User;
import week3.advanced.repository.PostRepository;
import week3.advanced.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostAssembler postAssembler;

    @Transactional
    public PostRes createPost(PostReq postReq) {
        User user = userRepository.findById(postReq.getUserIdx()).orElseThrow(null);
        Post post = postRepository.save(postAssembler.toEntity(postReq, user));
        return PostRes.toEntity(post);
    }
}
