package sopt.org.week2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.week2.dto.response.GetPostResponse;
import sopt.org.week2.service.PostLikeService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostLikeController {

    private final PostLikeService postLikeService;

    /**
     * 게시글 좋아요
     */
    @PutMapping("/like/{userId}/{postId}")
    public String likePost(@PathVariable final Long userId,
                           @PathVariable final Long postId) {
        return postLikeService.likePost(userId, postId);
    }

    /**
     * 게시글 좋아요 리스트 조회
     */
    @GetMapping("/like/{userId}")
    public List<GetPostResponse> getPostLike(@PathVariable final Long userId) {
        return postLikeService.getPostLike(userId);
    }

}
