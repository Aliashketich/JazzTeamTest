package by.testJazzTeam.repo;

import by.testJazzTeam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
