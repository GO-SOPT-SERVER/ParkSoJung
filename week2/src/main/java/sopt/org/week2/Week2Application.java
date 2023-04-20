package sopt.org.week2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sopt.org.week2.domain.Post;
import sopt.org.week2.domain.PostLike;
import sopt.org.week2.domain.User;

import java.util.ArrayList;

@SpringBootApplication
public class Week2Application {

	public static ArrayList<User> userList;
	public static ArrayList<Post> postList;
	public static ArrayList<PostLike> postLikeList;

	public static void main(String[] args) {
		SpringApplication.run(Week2Application.class, args);

		userList = new ArrayList<>();
		postList = new ArrayList<>();
		postLikeList = new ArrayList<>();
	}

}
