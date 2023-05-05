package sopt.week3.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.week3.domain.User;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);
}
