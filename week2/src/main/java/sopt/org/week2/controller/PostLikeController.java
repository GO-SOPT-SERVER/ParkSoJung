package sopt.org.week2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.week2.dto.request.LikePostRequest;
import sopt.org.week2.service.PostLikeService;

@RequiredArgsConstructor
@RestController
public class PostLikeController {

    private final PostLikeService postLikeService;

    /**
     * 게시글 좋아요
     */
    @PutMapping("/like/{userId}/{postId}")
    public String likePost(@PathVariable final Long userId,
                           @PathVariable final Long postId,
                           @RequestBody final LikePostRequest request) {
        return postLikeService.likePost(userId, postId, request);
    }

}
