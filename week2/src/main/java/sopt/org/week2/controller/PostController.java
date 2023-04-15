package sopt.org.week2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.week2.dto.request.RegisterPostRequest;
import sopt.org.week2.dto.response.GetPostResponse;
import sopt.org.week2.service.PostService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * 게시글 등록
     */
    @PostMapping("/post")
    public String registerPost(@RequestBody final RegisterPostRequest request) {
        Long postId = postService.registerPost(request);
        return postId + "번 게시글이 등록되었습니다 !";
    }

    /**
     * 게시글 검색 (게시글 id)
     * @param postId
     */
    @GetMapping("/post/{postId}")
    public GetPostResponse getPost(@PathVariable final Long postId) {
        return postService.getPost(postId);
    }

    /**
     * 게시글 검색 (게시글 제목)
     * @param title
     */
    @GetMapping("/post/search")
    public List<GetPostResponse> searchPost(@RequestParam final String title) {
        return postService.searchPost(title);
    }
}
