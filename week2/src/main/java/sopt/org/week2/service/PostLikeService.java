package sopt.org.week2.service;

import org.springframework.stereotype.Service;
import sopt.org.week2.domain.Post;
import sopt.org.week2.domain.PostLike;
import sopt.org.week2.dto.response.GetPostResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static sopt.org.week2.Week2Application.postLikeList;
import static sopt.org.week2.Week2Application.postList;

@Service
public class PostLikeService {
    public String likePost(Long userId, Long postId) {

        PostLike postLike = postLikeList.stream()
                .filter(pl -> pl.getUserId().equals(userId) && pl.getPostId().equals(postId)).findFirst()
                .orElse(null);

        if(postLike==null) {
            PostLike newPostLike = new PostLike(userId, postId, true);
            postLikeList.add(newPostLike);
            newPostLike.setId((long)postLikeList.size());
        } else postLike.setStatus(!postLike.isStatus());

        return "성공했습니다 !";
    }

    public List<GetPostResponse> getPostLike(Long userId) {
        List<Long> postLikes = postLikeList.stream().filter(pl -> pl.getUserId().equals(userId) && pl.isStatus())
                .map(PostLike::getPostId).collect(Collectors.toList());

        List<Post> posts = new ArrayList<>();
        for(Long postId : postLikes) {
            Post post = postList.get((int) (postId-1));
            posts.add(post);
        }

        return GetPostResponse.toDto(posts);
    }
}
