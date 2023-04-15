package sopt.org.week2.service;

import org.springframework.stereotype.Service;
import sopt.org.week2.domain.PostLike;
import sopt.org.week2.dto.request.LikePostRequest;

import static sopt.org.week2.Week2Application.postLikeList;

@Service
public class PostLikeService {
    public String likePost(Long userId, Long postId, LikePostRequest request) {
        PostLike postLike = new PostLike(userId, postId, request.isStatus());

        postLikeList.add(postLike);
        postLike.setId((long)postLikeList.size());
        return "성공했습니다 !";
    }
}
