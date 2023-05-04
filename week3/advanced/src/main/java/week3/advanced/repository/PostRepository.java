package week3.advanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import week3.advanced.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
