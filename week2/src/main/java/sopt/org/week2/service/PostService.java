package sopt.org.week2.service;

import org.springframework.stereotype.Service;
import sopt.org.week2.domain.Post;
import sopt.org.week2.dto.request.RegisterPostRequest;
import sopt.org.week2.dto.response.GetPostResponse;

import java.util.List;
import java.util.stream.Collectors;

import static sopt.org.week2.Week2Application.postList;

@Service
public class PostService {
    public String registerPost(Long userId, RegisterPostRequest request) {

        Post newPost = new Post(
                request.getTitle(),
                request.getContent(),
                userId
        );

        postList.add(newPost);
        newPost.setId((long)postList.size());

        return newPost.getId()+"번 게시글이 등록되었습니다 !";

    }

    public GetPostResponse getPost(Long postId) {
        Post post = postList.get((int) (postId-1));

        return GetPostResponse.toDto(post);
    }

    public List<GetPostResponse> searchPost(String title) {
        List<Post> posts = postList.stream().filter(p -> p.getTitle().contains(title)).collect(Collectors.toList());
        return GetPostResponse.toDto(posts);
    }

    public String deletePost(Long postId) {
        postList.remove((int) (postId-1));
        return "삭제되었습니다 !";
    }
}
