package sopt.org.week2.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week2.domain.Post;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class GetPostResponse {
    private Long postId;
    private String title;
    private String content;

    public static GetPostResponse toDto(Post post) {
        return new GetPostResponse(post.getId(), post.getTitle(), post.getContent());
    }

    public static List<GetPostResponse> toDto(List<Post> posts) {
        return posts.stream()
                .map(GetPostResponse::toDto).collect(Collectors.toList());
    }
}
