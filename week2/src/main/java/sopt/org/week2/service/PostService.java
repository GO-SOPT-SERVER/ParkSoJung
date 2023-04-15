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
    public Long registerPost(RegisterPostRequest request) {

        Post newPost = new Post(
                request.getTitle(),
                request.getContent()
        );

        postList.add(newPost);
        newPost.setId((long)postList.size());

        return newPost.getId();

    }

    public GetPostResponse getPost(Long postId) {
        Post post = postList.get((int) (postId-1));

        return GetPostResponse.toDto(post);
    }

    public List<GetPostResponse> searchPost(String title) {
        List<Post> posts = postList.stream().filter(p -> p.getTitle().contains(title)).collect(Collectors.toList());
        return GetPostResponse.toDto(posts);
    }
}
