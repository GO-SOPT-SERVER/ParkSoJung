package week3.advanced.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week3.advanced.controller.dto.request.PostReq;
import week3.advanced.controller.dto.response.PostRes;
import week3.advanced.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @ResponseBody
    @PostMapping("")
    public ResponseEntity<PostRes> createPost(@RequestBody final PostReq postReq) {
        return new ResponseEntity<>(postService.createPost(postReq), HttpStatus.CREATED);
    }
}
